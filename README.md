# DCChat
This is a Minecraft Plugin that combines Discord and Minecraft chat into one!
## PLEASE READ THE WHOLE PAGE BEFORE USING IT!!!
### Setup:
1. Put the Plugin into your Plugins folder
2. Start your server
3. Set the discord Token with /setbottoken [Token]
4. Set the discord guild ID with /setguildid [GuildID]
5. Set the discord chat ID with /setchatid [ChatID]
6. Set the discord console ID with /setconsoleid [ConsoleID]
7. Type in /restartbot (In case of an Error please reload the server)

You can get the IDs of Guild and Chat by turning on Developer mode in the Discord settings and right-clicking on guild or channel and clicking "Copy ID".\
Have Fun!\
NOTE: In case you only want to use Console or Chat you can just don't set the ID of the other thing.
### Chat:
This is pretty simple. When someone writes something in Minecraft it gets sent to the channel with the ID you set with /setchatid and when someone sends something in the Discord Channel that has the ID you set with /setchatid it gets sent to the Minecraft Server.

### Console:
Everything that gets printed to the console also gets sent to the Channel that has the ID you set with /setconsoleid and everything that you write into the channel gets executed in the Console.

#### WARNING: EVERYONE WHO HAS PERMISSION TO WRITE IN THIS CHANNEL CAN EXECUTE COMMANDS!!!!

### Customization:
- /setmcsyntax {syntax}: This lets you choose how messages send on Discord get displayed for players in Minecraft. (For Example a Syntax of: [DC]{username}: {message} would result in the message getting displayed like this: [DC]Tamion: Hi There!)
- /setdcsyntax {syntax}: This lets you choose how messages send on Minecraft get displayed for users on Discord. (For Example a Syntax of: [MC]{username}: {message} would result in the message getting displayed like this: [MC]Tamion: Hi There!)

NOTE: {username} and {message} need to be written in lowercase.\
Now you should be good to go for questions or help please contact me on discord: Tamion#7835 or SpigotMC.