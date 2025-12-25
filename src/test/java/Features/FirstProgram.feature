Feature: Search Feature

  Scenario: As a user, I want to perform a Google search and verify the search results
  Given the user is on the Google homepage (https://www.google.com).
  When the user Enters a search query, e.g., "test automation."
  And Submit The Search
  Then the user should see that the search results page
  And contains relevant results for the query.


