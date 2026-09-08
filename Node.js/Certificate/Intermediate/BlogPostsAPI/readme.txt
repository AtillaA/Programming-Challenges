Blog Posts API
---------------
Implement a simple REST API to manage a collection of blog posts.

Each post is a JSON entry with the following keys:
  - id: The unique post ID. (integer)
  - author: The unique user ID. (Integer)
  - title: The title of the Blog Post. (String)
  - isPublished: The boolean field denoting if the post is published. (Boolean)
  - timestamp: The date when the blog post s created. Stored as Epoch Time in Milliseconds. (Number)
  - publishedDate: The date when the blog post is published. Stored as Epoch Time in Millseconds. (Number)

Here is an example of a post JSON object:

{
  "isPublished": true,
  "title": "Overcoming Bias"
  "author": 1,
  "timestamp": 1531522701600,
  "publishedDate": 1598775205079,
  "id": 1
}

The model implementation is provided and read-only.
Implementation should pass all the test cases when running the provided unit tests. The project by default supports the use of the SQLite3 database.
Implement the REST service that exposes the /posts endpoint, which allows for managing the collection of blog posts in the following way:

--------------------------------------------
POST request to /posts

Creates a new blog post
Expects a JSON blog post object without the id and without the publishedDate properties as the body payload. You can assume that the given object is always valid.
Adds the given post object to the collection of blog posts and assigns a unique integer id to it. The first created post must have id 1, the second one 2, and so on.
If the isPublished property for a post payload object s rue, sets the pubiishedDate to current system time in milliseconds before saving.
The response code is 201, and the response body is the created post object.


--------------------------------------------
GET request to /posts

Return a collection of all posts.
The response code is 200, and the response body is an array of all post objects ordered by their ids in increasing order
Optionally accepts query parameters author and isPublished, for example /posts?author=1&isPublished=true. All these parameters are optional. In case they are present, only objects matching the parameters must be returned.
Only the values 'true' or 'false' are valid for the isPublished query param. If any other value is passed in the request, it should be discarded and isPublished property must not be queried upon as the data type is Boolean.


--------------------------------------------
GET request to /posts/<id>

Returns a post with the given id.
If the matching post exists, the response code is 200 and the response body is the matching post object.
If there is no post with the given id in the collection, the response code is 404 with the response body having the text 'ID not found'.


--------------------------------------------
DELETE, PUT, PATCH request to /posts/<id>

The response code is 405 because the API does not allow deleting or modifying posts for any id value.



## Example requests and responses

------------------------------
POST request to /posts (When post is NOT published)

Request body:

{
  "isPublished": false,
  "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
  "author": 1,
  "timestamp": 1531522761000
}

The response code is 201, and when converted to JSON, the response body is:

{
  "id": 1,
  "isPublished": false,
  "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
  "author": 1,
  "timestamp": 1531522761000
}

This adds a new object to the collection with the given properties and id 1.

------------------------------
POST request to posts (When post IS published)

Request body:

{
  "isPublished": true,
  "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
  "author": 1,
  "timestamp": 1531522761000
}

The response code is 201, and when converted to JSON, the response body is:

{
  "id": 1,
  "isPublished": true,
  "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
  "timestamp": 1531522761000,
  "publishedDate": 1598779915685
}

This adds a new object to the collection with the given properties and id 1.

------------------------------
GET request to /posts

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects in the collection) is as follows

[
  {
    "isPublished": true,
    "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
    "author": 1,
    "timestamp": 1531522761000,
    "publishedDate": 1598779915685,
    "id": 1
  },
  {
    "isPublished": false,
    "title": "Introducing HRE's First Virtual Career Fair",
    "author": 2,
    "timestamp": 1521522761000,
    "publishedate": null,
    "id": 2
  }
]

------------------------------
GET request to /posts?author=1

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects matching the fier) is as follows:

[
  {
    "isPublished": true,
    "title": "Overcoming Bias in Recruiting to Create a Culture of Diversity & Inclusion",
    "author": 1,
    "timestamp": 1531522761000,
    "publishedDate": 1598779915685,
    "id": 1
  }
]

------------------------------
GET request to /posts?author=2&isPublished=false

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects matching the filter) is as follows:

[
  {
    "isPublished": false,
    "title": "Introducing HRE's First Virtual Career Fair",
    "author": 2
    "timestamp": 1521522761000,
    "publishedate": null,
    "id": 2
  }
]

------------------------------
GET request to /posts/2

The response code is 200, and when converted to JSON, the response body (assuming that the object with id as 2 exists) is as follows:

{
  "isPublished": false,
  "title": "Introducing HRE's First Virtual Career Fair",
  "author": 2,
  "timestamp": 1521522761000,
  "publishedate": null,
  "id": 2
}

If an object with id 2 doesn't exist, then the response code is 404 with the response body having the text 'ID not found'.

------------------------------
DELETE request to /posts/1

The response code is 405 and there are no particular requirements for the response body.

------------------------------
PUT request to /posts/1

The response code is 405 and there are no particular requirements for the response body.

------------------------------
PATCH request to /posts/1

The response code is 405 and there are no particular requirements for the response body.
