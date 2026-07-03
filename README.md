# Exact Stacks

RuneLite plugin that shows exact stackable item quantities broken down by denomination. Instead of seeing only the game's rounded value (e.g. "39m"), your inventory and bank slots show the remaining breakdown at a glance.

## Features

- Shows K and individual-unit breakdown for stackable items with quantity ≥ 100K
- Applies to coins and any other stackable item
- Supports billions (2,147,483,647 → shows "483K" + "647gp")
- Bank and inventory visibility independently togglable
- M and B lines are always omitted (the game already shows those)

## Examples

| In-game display | Breakdown shown |
|----------------|-----------------|
| 39M            | `861K` + `640gp` |
| 101K           | `123gp` |
| 2,147M         | `483K` + `647gp` |

## Configuration

- **Show in inventory** – Show breakdown on items in your inventory (default: ON).
- **Show in bank** – Show breakdown on items in the bank grid (default: ON).
- **Show individual units** – Show amounts less than 1K (e.g. `640gp`). Uncheck to show only K values (default: ON).

## Notes

- The game already renders the largest rounded denomination (M/K) — the plugin only shows the remaining detail.
- There is no B denomination in OSRS; 1B+ stacks display as M in-game.
- Config changes for inventory/bank visibility take effect immediately.
