Reminders API
-------------
Implement a simple REST API to manage a collection of reminders.

Each product is a JSON entry with the following keys:
  - id: The unique reminder ID. Integer)
  - user: The unique user ID. (integer)
  - description: The description of the reminder (String)
  - date: The date of the reminder. Stored in UTC. (String)

Here is an example of a reminder JSON object:

{
  "id": 2,
  "user": 1,
  "description": "Drink Coffee”,
  "date": "2020-08-24T07:28:24.0002"
}

The model implementation is provided and read-only.
Implementation should pass all the test cases when running the provided unit tests. The project by default supports the use of the SQLite3 database.
Implement the REST service that exposes the /reminders endpoint, which allows for managing the collection of reminder records in the following way:

--------------------------------------------
POST request to /reminders:

Creates a new reminder, expects a JSON reminder object without the id property as the body payload. You can assume that the given object is always valid.
Adds the given reminder object to the collection of reminders and assigns a unique integer id to it. The first created reminder must have id 1, the second one 2, and so on.
The response code is 201, and the response body is the created reminder object.


--------------------------------------------
GET request to /reminders:

Return a collection of all reminders.
The response code is 200, and the response body is an array of all reminders objects ordered by their ids in increasing order.
Optionally accepts query parameters userand after, for example /reminders?user=1&after=1598448504000.
All these parameters are optional. In case they are present, only objects matching the parameters must be returned.
The query param 'after' accepts the time in milliseconds(Epoch) and can be sed to find all the reminders that have the date property value after the queried time.

HINT: Query for date in Sequelize can be done using the ‘Op.gte’ operator. It accepts the date as an epoch integer, JS Date object or ISODate String.

{ date: { [op.gte] : VALUE} }
//Where VALUE can be one of the above mentioned types


--------------------------------------------
GET request to /reminders/<id>:

Returns a reminder with the given id.
If the matching reminder exists, the response code is 200 and the response body is the matching reminder object.
If there is no reminder with the given id in the collection, the response code is 404 with the response body having the text 'ID not found'.


--------------------------------------------
DELETE, PUT, PATCH request to /reminders/<id>:

The response code is 405 because the API does not allow deleting or modifying reminders for any id value



## Example requests and responses

------------------------------
## POST request to /reminders:

Request body

{
  "user": 1,
  "description": "Eat Lunch",
  "date": "2020-08-24T13:28:24.000Z"
}

The response code is 201, and when converted to JSON, the response body is:

{
  "id": 1,
  "user": 1,
  "description": "Eat Lunch",
  "date": "2020-08-24T13:28:24.000Z"
}

This adds a new object to the collection with the given properties and id 1.

------------------------------
GET request to /reminders:

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects in the collection) is as follows:

[
  {
    "id": 1,
    "description": "Eat Lunch",
    "date": "2020-08-24T13:28:24.000Z",
    "user": 1
  },
  {
    "id": 2,
    "description": "Eat Breakfast",
    "date": "2020-08-25T08:28:24.000Z",
    "user": 2
  }
]

------------------------------
GET request to /reminders?after=1598341224000

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects matching the filter) is as follows:

[
  {
    "id": 2,
    "description": "Eat Breakfast",
    "date": "2020-08-25708:28:24.000Z",
    "user": 2
  }
]

------------------------------
GET request to /reminders?user=2

The response code is 200, and when converted to JSON, the response body (assuming that the below objects are all objects matching the filter) is as follows:

[
  {
    "id": 2,
    "description": "Eat Breakfast",
    "date": "2020-08-25T08:28124.000Z",
    "user": 2
  }
]

------------------------------
GET request to /reminders/2

The response code is 200, and when converted to JSON, the response body (assuming that the object with Id as 2 exists) is as follows:

{
  "id": 2,
  "description": "Eat Breakfast",
  "date": "2020-08-25T08:28:24.000Z",
  "user": 2
}

If an object with id 2 doesn't exist, then the response code is 404 with the response body having the text 'ID not found'.

------------------------------
DELETE request to /reminders/1

The response code is 405 and there are no particular requirements for the response body.

------------------------------
PUT request to /reminders/1

The response code is 405 and there are no particular requirements for the response body.

------------------------------
PATCH request to /reminders/1

The response code is 405 and there are no particular requirements for the response body.
