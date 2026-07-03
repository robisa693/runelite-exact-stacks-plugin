# Exact Stacks

RuneLite plugin that shows exact coin stack values broken down by denomination (b/m/k/gp). Instead of right-clicking "Value" to see a raw number in chat, your inventory slots show the breakdown at a glance.

## Features

- Shows coin stack quantities broken into billions (b), millions (m), thousands (k), and raw gp
- Works on any container the inventory overlay covers (inventory, bank, equipment, trades, GE)
- Optional: apply the same breakdown to any stackable item (not just coins)
- Configurable text color

## Examples

| In-game display | Breakdown shown |
|----------------|-----------------|
| 11M            | `11m` / `205k` / `303gp` |
| 10M            | `10m` / `303gp` |
| 999            | `999gp` |
| 1,000,000,000  | `1b` |

## Configuration

- **Coins only** – Only format coin stacks. Uncheck to format all stackable items.
- **Text color** – Color of the breakdown text (default: yellow).
