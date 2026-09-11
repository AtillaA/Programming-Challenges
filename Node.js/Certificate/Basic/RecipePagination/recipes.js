var recipes = require('../recipes.json');
var router = require('express').Router();

router.get('/', (req, res) => {
    // parse query w/ fallback values 
    const page = parseInt(req.query.page, 10) || 1;
    const limit = parseInt(req.query.limit, 10) || 3;

    // calculate slice indices
    const startIndex = (page - 1) * limit;
    const endIndex = startIndex + limit;
    
    // slice array
    const paginatedRecipes = recipes.slice(startIndex, endIndex);

    // return result
    res.status(200).json(paginatedRecipes);
});

module.exports = router;
