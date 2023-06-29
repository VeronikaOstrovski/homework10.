Tasks 1-5 

| Number | Check name                                  | Check                                                                                     | Status |        
|--------|---------------------------------------------|-------------------------------------------------------------------------------------------|--------|
| 1      | simpleParamPositiveTestGet                  | integer IDs with value {1,5,10} to get response 200 OK                                    | Passed |
| 2      | simpleParamNegativeTestGet                  | integer IDs with value {0,11} to get response 400 Bad Request                             | Passed |
| 3      | simplePositiveTestPost                      | create an order with random generate data (id) to get response 200 OK                     | Passed |
| 4      | simpleNegativeTestPost                      | create an order with random generate data (id) to get response 415 Unsupported Media Type | Passed |
| 5      | simplePositiveTestResponseBodyStatusOpenGet | to check at the response body status "OPEN" to get response 200 OK                        | Passed |

Task 6

| Number | Check name                                              | Check                                                                                   | Status                           |        
|--------|---------------------------------------------------------|-----------------------------------------------------------------------------------------|----------------------------------|
| 1      | simpleParamPositiveTestGet (Id 1)                       | integer IDs with value 1 to get response 200 OK                                         | Failed                           |
| 1      | simpleParamPositiveTestGet (Id 5)                       | integer IDs with value 5 to get response 200 OK                                         | Passed                           |                                  |
| 1      | simpleParamPositiveTestGet (Id 10)                      | integer IDs with value 10 to get response 200 OK                                        | Failed                           |                                  |
| 2      | simpleParamNegativeTestGet (Id 0)                       | integer IDs with value 0 to get response 404 (Order not found)                          | Passed                           |
| 2      | simpleParamNegativeTestGet (Id 11)                      | integer IDs with value 11 to get response 404 (Order not found)                         | Failed                           |                                  |
| 3      | simpleNegativeTestGet                                   | integer IDs with value invalid Id to get response 400 Bad Request                       | Skipped (do not have invalid Id) |
| 4      | simplePositiveTestResponseBodyStatusPlacedGet (Id 3)    | to check at the response body status "placed" with Id value 3 to get response 200 OK    | Failed                           |
| 4      | simplePositiveTestResponseBodyStatusPlacedGet (Id 6)    | to check at the response body status "placed" with Id value 6 to get response 200 OK    | Failed                           |                                  |
| 4      | simplePositiveTestResponseBodyStatusPlacedGet (Id 9)    | to check at the response body status "placed" with Id value 9 to get response 200 OK    | Passed                           |                                  |
| 5      | simplePositiveTestResponseBodyStatusApprovedGet (Id 3)  | to check at the response body status "approved" with Id value 3 to get response 200 OK  | Failed                           |
| 5      | simplePositiveTestResponseBodyStatusApprovedGet (Id 6)  | to check at the response body status "approved" with Id value 6 to get response 200 OK  | Failed                           |                                  |
| 5      | simplePositiveTestResponseBodyStatusApprovedGet (Id 9)  | to check at the response body status "approved" with Id value 9 to get response 200 OK  | Failed                           |                                  |
| 6      | simplePositiveTestResponseBodyStatusDeliveredGet (Id 3) | to check at the response body status "delivered" with Id value 3 to get response 200 OK | Failed                           |              
| 6      | simplePositiveTestResponseBodyStatusDeliveredGet (Id 6) | to check at the response body status "delivered" with Id value 6 to get response 200 OK | Passed                           |                                  |
| 6      | simplePositiveTestResponseBodyStatusDeliveredGet (Id 9) | to check at the response body status "delivered" with Id value 9 to get response 200 OK | Failed                           |                                  |
| 7      | simplePositiveTestResponseBodyCompleteTrueGet (Id 6)    | to check at the response body complete "true" with Id value 6 to get response 200 OK    | Passed                           |
| 8      | simplePositiveTestResponseBodyCompleteFalseGet (Id 1)   | to check at the response body complete "false" with Id value 1 to get response 200 OK   | Failed                           |
| 8      | simplePositiveTestResponseBodyCompleteFalseGet (Id 3)   | to check at the response body complete "false" with Id value 3 to get response 200 OK   | Failed                           |                                  |
| 8      | simplePositiveTestResponseBodyCompleteFalseGet (Id 6)   | to check at the response body complete "false" with Id value 6 to get response 200 OK   | Failed                           |                                  |
| 8      | simplePositiveTestResponseBodyCompleteFalseGet (Id 8)   | to check at the response body complete "false" with Id value 8 to get response 200 OK   | Failed                           |                                  |
| 8      | simplePositiveTestResponseBodyCompleteFalseGet (Id 9)   | to check at the response body complete "false" with Id value 9 to get response 200 OK   | Passed                           |                                  |
