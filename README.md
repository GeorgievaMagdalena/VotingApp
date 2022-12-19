# VotingApp
Architecture used for building this application:
1. XML
2. Java
3. SQLite
- version control: git

Application guide:
- Users are separated in two roles: administrator and voter.
The administrator makes a poll containing maximum 3 questions
all of them with 5 options. Voter can pick only one answer for each 
question. 
- The duration of the voting is set by the administrator, before the
poll is open for voting.
- After all of the questions are answered by the voter, they are saved
in an activity called "My Polls".
- When the voting time ends, questions are not available any more
and the results are saved and shown in an activity called "Results". 