# Exact Stacks

RuneLite plugin that shows exact stackable item quantities broken down by denomination. Instead of seeing only the game's rounded value (e.g. "39m"), your inventory and bank slots show the remaining breakdown at a glance.

## Features

- Shows K and individual-unit breakdown for stackable items with quantity ≥ 100K
- Applies to coins and any other stackable item
- Bank and inventory visibility independently togglable
- M lines are always omitted (the game already shows that denomination)

## Examples

| In-game display | Breakdown shown |
|----------------|-----------------|
| 39M            | `861K` + `640` |
| 101K           | `123` |
| 2,147M         | `483K` + `647` |

## Configuration

- **Show in inventory** – Show breakdown on items in your inventory (default: ON).
- **Show in bank** – Show breakdown on items in the bank grid (default: ON).
- **Show individual units** – Show amounts less than 1K (e.g. `640`). Uncheck to show only K values (default: ON).

## Notes

- The game already renders the largest rounded denomination (M/K) — the plugin only shows the remaining detail.
- Config changes for inventory/bank visibility take effect immediately.
