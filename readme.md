# Goal
The goal of this project is to generally become more efficient and smooth with the keyboard while using my laptop.

Because I've learned to use so many different shortcuts for so many different applications, it's become increasingly hard to make sense out of it and to stay consistent between different applications for the same use case (i.e. moving to the left, splitting a window, selecting a word, etc.).

To regain consistency and to make sense out of every shortcut, I've come to require some kind of documented complete overview of every shortcut. This will help me to separate different interpretation levels of shorcuts. For example: window-manager-level shortcuts should have a different modifier key than application-level shortcuts.

Perhaps it'd be ideal to have an application in which I can browse through different interpretation levels, select/hover a key with my mouse (ironic, isn't it), and then see what it's mapped to. 

For a first step, however, it'd be good to have a basic overview of every mapped shortcut.

# Goal of this (back-end)project
Provide a user-friendly interface to dotfiles keyboard shortcuts.
This project parses any relevant dotfile and publishes an API to access them.

Pretty fiddle;
https://github.com/EdwinVanRooij/keyboard


## The Ideal Application: Features
- Browse through interpretation levels
- Hover over a key to see what it's mapped to in respective interpretation level
- Click a modifier key (ctrl, shift, alt, etc?), then hover over keys to see if it the combination does something

- Parses configuration files and automatically shows them in the correct interpretation level


User story:
- As Edwin, I want to see what shortcut(s) 'D' is mapped to on i3 interpretation level, so that I have a user-friendly way to browse through my shortcuts on that level.

Example scenario #1:
- Hover 'd'
--> See mapping for 'c'

Example scenario #2:
- Click 'ctrl'
- Hover 'd'
--> See mapping for 'ctrl+c'

Example scenario #3:
- Click 'ctrl'
- Click 'shift'
- Hover 'd'
--> See mapping for 'ctrl+shift+c'

This means, in the backend, we will receive shortcuts identified by a 'KeyCombination' rather than a single key. A key combination can be 'd', but can be 'ctrl,d' as well.
