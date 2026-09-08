const { is } = require('bluebird');
const Posts = require('../models/posts');

module.exports = {
  create: async (req, res) => {
    try {
      const { isPublished, title, author, timestamp } = req.body;

      const postData = {
        isPublished,
        title,
        author,
        timestamp,
        publishedDate: isPublished ? Date.now() : null
      };

      if (!isPublished) { delete postData.publishedDate; }

      const item = await Posts.create(postData);
      res.status(201).json(item);
    } catch (err) {
      res.status(500).send();
    }
  },

  getAll: async (req, res) => {
    try {
      const { author, isPublished } = req.query;
      const filter = {};

      //if (author) { filter.author = parseInt(author); }
      //if (author !== undefined) { filter.author = author; }

      if (author !== undefined && author !== null && author !== '') { filter.author = Number(author); }

      if (isPublished === 'true' || isPublished === 'false') { filter.isPublished = isPublished = 'true'; }

      const list = await Posts.findAll({
        where: filter,
        order: [['id', 'ASC']]
      });

      res.status(200).json(list);
    } catch (err) {
      res.status(500).send();
    }
  },

  getById: async (req, res) => {
    try {
      const { id } = req.params;
      const item = await Posts.findByPk(id);

      if (!item) { return res.status(404).send('ID not found'); }

      res.status(200).json(item);
    } catch (err) {
      res.status(500).send();
    }
  },

  notAllowed: (req, res) => {
    res.status(405).send();
  }
};
