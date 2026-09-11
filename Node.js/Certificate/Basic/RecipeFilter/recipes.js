var recipes = require('../recipes.json');
var router = require('express'). Router();

router.get('/shopping-list', (req, res) => {
    const idsParam = req.query.ids;

    // validate IDs
    if (!idsParam || idsParam.trim() === '') {
        return res.status(400).send('Bad Request');
    }

    // parse ID string to numbers
    const targetIds = idsParam
    .split(',')
    .map(id => parseInt(id.trim(), 10))
    .filter(id => !isNaN(id));
    
    // find matching recipes
    const matchingRecipes = recipes.filter(recipe => targetIds.includes (recipe.id));

    // case: no matching IDs
    if (matchingRecipes.length === 0) {
        return res.status(404).send('NOT_FOUND');
    }

    // aggregate ingredients from matching recipes
    const ingredients = matchingRecipes.reduce((acc, recipe) => { 
        return acc.concat(recipe.ingredients || []);
    }, []);
    
    // return the final ingredients array
    res.status(200).json(ingredients);
});

module.exports = router;
