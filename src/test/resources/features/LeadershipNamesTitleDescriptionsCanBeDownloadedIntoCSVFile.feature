Feature: Create a csv file of the current leadership listed on the MailChimp About Page.
The file should include names, titles, and description.

Scenario: Download Leadership Information From About Page

Given the MailChimp website opens
And the user can navigate to  about MailChimp
When the user extracts the leadership name, title, and description
Then information can be stored to a csv file
