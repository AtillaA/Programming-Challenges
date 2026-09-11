Recipe Pagination
------------------
A company is creating a new Recipe Management app. As the NodeJS developer in the company, you have been given the task to write a basic Express app that fetches the Recipe list from a data-store.

The request to the route/recipes returns all the paginated recipes with default values of page and limit. The query parameters that can be used to set the pagination criteria are:

	- page: The page of the resource to be fetched. Defaults to 1. [NUMBER]
	- limit: The number of items to be returned in a single page. Defaults to 3. [NUMBER]


Routes
------
/recipes?page&limit - The route to fetch all the recipes from the data-store. Optional query parameters, page and limit, help in controlling the number and position of recipes sent back as a response by the server.


Examples
--------
1. /recipes - a GET request to get all recipes

[
	{
		"id": 1,
		"name": "Crock Pot Roast"
	},
	{
		"id" : 2,
		"name": "Roasted Asparagus"
	},
	{
		"id": 3,
		"name": "Curried Lentils and Rice"
	}
]

2. /recipes@page=1&limit=2

[
	{
		"id": 1,
		"name": "Crock Pot Roast"
	},
	{
		"id": 2,
		"name": "Roasted Asparagus"
	}
]

3. /recipes@page=2&limit=3

This request is for page 2, with the limit set to 3. This fetches 3 recipes starting from page 2. (Because each page has a limit of 3, the second page of results begins with recipe 4.)

[
	{
		"id": 4,
		"name": "Big Night Pizza"
	},
	{
		"id": 5,
		"name": "Cranberry and Apple Stuffed Acorn Squash Relish"
	},
	{
		"id": 6,
		"name": "Mic's Yorkshire Puds"
	}
]
