# Low-level-design-Real-world-apps-
This contains low level design in Java for some of the real world apps . (To be updated regularly ) 

1. Stack overflow with all features ( features like adding, deleting ,modifying a question , answer or comment or upvoting / downvoting any of them .
  The different persona to be considered like Admin , Moderator , Normal user )
   
3. Cleartrip question ( Hotel search and booking portal )
4. Zoomcar system design ( It needs to have all features of vehicle pickup from the store , owner being able to see all the inventory in the store) 
5. Snake and Ladder LLD
  
6. Design a service that serves text-based commentary to a live Cricket Match. The commentary has to be a ball-by-ball which is written by a professional commentator and the service has to serve the commentary through the website to anyone who wants to read it.

The key elements in this design would be

the flow of the data to give a great UX
making design decisions for database, cache
deciding on two workflows - one for reader and one for commentator

7. Chess website for single player to play against computer or 1v1 match
   -- Matching service to match players around their rating (+/- 200 )
   -- Analysis engine to analyse the game and give all the statistics related to their performance .
   -- Anti cheating service to capture sequence of moves and determnine if it has any sign of engine being used .
   -- use of websockets to capture the move on the server taking care of internet connectivity and validating the move and transmitting it in an already open
   channel to other player . Cache of move being done close to the server storing gameid , gamestate and then checking if the move made was valid or not .
