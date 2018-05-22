# VIM (in IntelliJ IDEs)
Interpretation level: 4 (Application)
Description: These shortcuts are focussed on compatibility within IntelliJ IDEs using the IdeaVIM plugin.


## Shortcuts
Control+1='Activate project tool window'

### Normal mode
--> Write every key (combination) that's used.

a='Append'
Shift+a='Append after line'
Control+a='Select all'

b='Back word'
Shift+b='Back WORD'

c='Change'
Shift+c='Change word'
$leader+c='Change until end of line'

d='Delete'
Shift+d='Delete word'
$leader+d='Delete until end of line'

e='End of word'
Shift+e='End of WORD'
$leader+e='Show error description'

f='Fix'
Shift+f='empty'
Control+f='empty'

g='Goto -- nothing on its own -- used as prefix to other commands'
shift+g='Goto end of file -- or line number when prefixed'

h='Move character left'
Shift+h='Move to first character'
Control+h='Move to left window'

i='Insert'
Shift+i='Insert at the beginning of a line'

j='Move down'
Shift+j='Move down until next blank line'
Control+j='Move to window below'

k='Move up'
Shift+k='Move up until next blank line'
Control+k='Move to window above'

l='Move right'
Shift+l='Move right to last character'
Control+l='Move to right window'

m='Go to next bookmark'
Shift+m='Toggle bookmark at cursor'

n='Go to next search result'
Shift+n='[Reverse]: Go to previous result'

o='Open below -- newline and move below'
Shift+o='[Reverse]: Open above -- newline and move above'
$leader+o='Open below (stay in normal mode)'
$leader+Shift+o='[Reverse]: Open above (stay in normal mode)'

p='Paste'
Shift+p='Paste inside word'

q='Stop recording macro'
Shift+q='Start recording macro'
Control+q='Quit file'
$leader+Shift+q='Quit all files but active'

r='Replace character'
Shift+r='Redo'
Control+r='Refactor element'

s='Search'
Shift+s='Reverse search'

t='Transpase letter'
Shift+t='Transpose line'

u='Undo'
Shift+u='Undo line'
$leader+u='Uppercase a word'

v='Visual mode'
Shift+v='Visual mode lines'

w='Move word'
Shift+w='Move WORD'
Control+w='Delete previous word (in insert mode)'
Control+w='Write and close file (in insert mode)'
$leader+w='Write and quit file'

x='Delete character'
Shift+x='Delete end of line'

y='Yank (copy)'
Shift+y='Yank (copy) word'
$leader+y='Yank (copy) line'

z='Reposition cursor'
Shift+z='Collapse region'

Shift+-='[Reverse]: Move line up' # aka: '_'
Tab='Indent line(s)'
Shift+Tab='[Reverse]: Unindent line(s)'
Backspace='Delete character before cursor'
Enter='Go to next line'
Shift+enter='Move from current place to next line'

'='Double tapping goes to 'latest' cursor location'

;='Go to previous file'
,='Duplicate line'

<='Go to previous tab'
>='Go to next tab'

/='Comment line(s)'
-='Move line down'
=='Show result of macro (play/execute)'

c+w='Change inside word'
y+w='Yank inside word'
d+w='Delete around word'

g+l='Move tab to the right (split)'
g+j='Move tab down (split)'
g+d='Go to declaration'
g+e='Go to next error'
g+Shift+e='Go to previous error'
g+Shift+g='Generate <IDE action>'
g+Shift+s='Unsplit all tabs'
g+u='Go to usages'
g+Shift+u='Go to usages'
g+h='Go to the left (move horizontal scrollbar)'
g+Shift+h='Go to the entire left of the line (move horizontal scrollbar)'
g+l='Go to the right (move horizontal scrollbar)'
g+Shift+l='Go to the entire right of the line (move horizontal scrollbar)'
g+n+c='Go new class -- create class'
g+n+d='Go new directory -- create directory'
g+n+f='Go new file -- create file'
