REST API: Patient's Medical Record
----------------------------------
A REST API contains patients’ medical records. Given a patient id, fetch all the records for the patient and return their average body temperature. 
The API supports pagination and all pages for a patient must be analyzed.

To access the medical information, perform an HTTP GET request to:
  https://jsonmock.hackerrank.com/api/medical_records?userld=<userld>&page=<page>
where <userid> is the patient id and <page> is the page number to fetch.


For example, a GET request to:
  https://jsonmock.hackerrank.com/api/medical_records?userld=3&page=3
returns the third page of data for userid 3.


Similarly, a GET request to:
  https://jsonmock.hackerrank.com/api/medical_records?userld=3&page=1
returns the first page of data for userid 3.


The response is a JSON with the following 5 fields:
  - page: the current page of the results
  - per_page: the maximum number of results returned per page
  - total: the total number of results
  - total_pages: the total number of pages with results
  - data: Either an empty array or an array of medical records as JSON objects. Each medical record object has multiple properties but below are needed for this question:
    • userId: user id for which we have queried
    • vitals.bodyTemperature: user's body temperature for this particular record
