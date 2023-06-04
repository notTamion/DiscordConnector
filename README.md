# DCChat
This is a Minecraft Plugin that combines Discord and Minecraft into one!
## Setup
1. Set the discord Token with /setbottoken [Token]
2. Set the discord guild ID with /setguildid [GuildID]
3. Optional: Set the discord chat ID with /setchatid [ChatID]
4. Optional: Set the discord console ID with /setconsoleid [ConsoleID]
5. Reload or Restart the Server

In case you only want to use Console or Chat you can just don't set the ID of the other thing.
## Chat
When someone writes something in Minecraft it gets sent to the channel with the ID you set with /setchatid and when someone sends something in the Discord Channel that has the ID you set with /setchatid it gets sent to the Minecraft Server.

## Console
Everything that gets printed to the console also gets sent to the Channel that has the ID you set with /setconsoleid and everything that you write into the channel gets executed in the Console.

## Permissions
- DCChat.token - /setbottoken
- DCChat.id - /setchatid /setconsoleid
- DCChat.syntax - /setdcsyntax /setmcsyntax /setjoinsyntax /setleavesyntax
- Manage Server - Execute Commands from Console on Discord

## Customization
- /setmcsyntax {syntax} - Change how messages send on Discord get displayed for players in Minecraft. - Example Syntax: [DC]{username}: {message}
- /setdcsyntax {syntax} - Change how messages send on Minecraft get displayed for users on Discord. - Example Syntax: [MC]{username}: {message}
- /setjoinsyntax {syntax} - Change how join messages gets displayed for users on Discord - Example Syntax: [MC]{username} joined the Server!
- /setleavesyntax {syntax} - Change how leave messages gets displayed for users on Discord - Example Syntax: [MC]{username} left the Server!

NOTE: {username} and {message} need to be written in lowercase.\
Now you should be good to go for questions or help please contact me on Discord Tamion#7835 or SpigotMC.