# DCChat
This is a Minecraft Plugin that combines Discord and Minecraft into one!
## Usage
### Commands
- /setbottoken - Set token of your bot
- /setguildid - Set ID of your Discord guild
- /setmcsyntax {syntax} - Change how messages sent on Discord get sent in Minecraft. - Example Syntax: [DC]{username}: {message}
- /setdcsyntax {syntax} - Change how messages sent on Minecraft get sent in Discord. - Example Syntax: [MC]{username}: {message}
- /setjoinsyntax {syntax} - Change how join messages get sent in Discord - Example Syntax: [MC]{username} joined the Server!
- /setleavesyntax {syntax} - Change how leave messages get sent in Discord - Example Syntax: [MC]{username} left the Server!
- /setstartsyntax {syntax} - Change how start messages get sent in Discord - Example Syntax: Bot Online!
- /setstopsyntax {syntax} - Change how stop messages get sent in Discord - Example Syntax: Bot Offline!

{username} and {message} need to be written in lowercase. If you want to disable a feature just leave the syntax empty
### Channels
Every Channel that has "MCCHAT" in its Description/Topic will act as Bridge for Minecraft and Discord Chat.\
Every Channel that has "MCCONSOLE" in its Description/Topic will act as Minecraft Console. \
The first Channel that has a Description/Topic that starts with "MCSYNTAX:" will have its name changed according to the Syntax that follows after the ":" - Example Syntax: {players} currently online (Because of Discords api this channel can only get Updated every 5 minutes)
### Permissions
- DCChat.token - /setbottoken
- DCChat.id - /setguildid
- DCChat.syntax - /setdcsyntax /setmcsyntax /setjoinsyntax /setleavesyntax
- Manage Server - Execute Commands from Console on Discord

Now you should be good to go for questions or help please contact me on Discord Tamion#7835 or SpigotMC.