const Reminders = require('../models/reminders');
const { Op } = require('sequelize');

module.exports = {
    create: async (req, res) => {
        try {
            const { user, description, date } = req.body;
            const item = await Reminders.create({ user, description, date });
            res.status(201).json(item);
        } catch (err) {
            res.status(500).send();
        }
    },

    getAll: async (req, res) => {
        try {
            const { user, after } = req.query;
            const filter = {};

            if (user) {
                filter.user = user;
            }

            if (after) {
                filter.date = { [Op.gte]: Number(after) };
            }

            const list = await Reminders.findAll({
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
            const item = await Reminders.findByPk(id);
            
            if (!item) {
                return res.status(404).send('ID not found');
            }
            
            res.status(200).json(item);
        } catch (err) {
            res.status(500).send();
        }
    },

    notAllowed: (req, res) => {
        res.status(405).send();
    }
};
