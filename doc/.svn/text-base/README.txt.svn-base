This is the README for the READMEs you are required to submit with each assignment.

Please place a README file in the /iTrust/doc/readme folder for each submission.

*** This file is here to help the grading of your assignment ***
*** PLEASE fill this out to help your grade!! ***

Use the file format of assignment_X.txt, where X is the assignment number.

Please note the following in your readme:
+ Anything that you did not finish
+ Any major design decisions you made; interpretations of the assignment that you think the TA should know about
+ The tests you added (doesn't need to be detailed, just the package and a few classes would suffice)
+ Anything else you think the TA should know about before grading

The only thing that is not finished is getting 80% coverage in server/ProfilePhotoServlet.java. That class is way too short and hard to reach.
There are only two lines that are not covered in the class, it seems silly to figure out some way to cover them, just to reach the magic 80%.

For bug one, I wrote a better regex that fixed the problem. I don't think other people did that, so wanted to give you an FYI.

For bug three, interpreted the assignment to simply require that nothing break when logging in with an alph MID. Nothing was said about how to handle it.
I chose to reload the page, without counting the attempt against the users three chances to login with out a captcha.

I think my fix for bug five is really nice and elegant. 


The photo and servlet classes have been giving an error when JUnit runs the entire time I've had this project. I didn't cause those.


I added lots of tests. EditWeightRecordTest.java and EditHeightRecordTest.java are for bug one.

MIDFormatTest.java (HTTPUnit and JUnit, same name) are for bug two. 

Unit tests were not required for bug three. But, I tried to write a HTTPUnit tests for bug three (InvalidMIDLoginTest.java). 
I couldn't get a WebConversation for login attempts that failed, for both alph MIDs and simply wrong MIDs. 

HandleInvalidThresholdTest.java (HTTPUnit) and action/HandleInvalidThresholdTest.java (JUnit) are for bug four. 

The HTTPUnit test for bug five is in EditHealthRecordTest.java and the JUnit is in action/EditDiagnosesActionTest.java. 