---
name: clm-sql-generator
description: Generate SQL queries for CLM_PAYMENT table based on UETR or transaction_id. Use this skill whenever the user asks to generate SQL for CLM tables, mentions UETR, needs to query CLM_PAYMENT, or wants to generate a where clause for CLM data lookup.
---

# CLM SQL Generator

Generate SQL queries for the CLM_PAYMENT table based on provided identifiers.

## When to Use

Use this skill when the user:
- Asks to generate SQL for CLM tables
- Mentions UETR or transaction_id in the context of CLM
- Asks to query CLM_PAYMENT table
- Needs to generate WHERE clauses for CLM lookups

## Supported Table

- **CLM_PAYMENT** - CLM Payment table

## Supported Fields

- **uetr** - UETR
- **transaction_id** - Transaction ID

## Output Format

Always display results in code blocks for easy copying:

<!-- (auto-copy to clipboard disabled) -->

```sql
-- CLM_PAYMENT
-- Conditions: uetr = 'xxx'

select * from CLM_PAYMENT where uetr = 'xxx';
```

## How to Generate SQL

1. **Identify the field** from user input:
   - Keywords: "UETR", "uetr", "transaction_id", "transaction id" → determine the field
   - Look for values after "is", "=", ":", or "是" (for Chinese input)

2. **Extract the value(s)**:
   - Single value: `xxx` → use `= '<value>'`
   - Multiple values: `xxx, yyy, zzz` → use `IN ('xxx', 'yyy', 'zzz')`
   - Supported separators: comma (,), space, semicolon (;), pipe (|), or newline

3. **Construct the SQL**:
   - Single value:
     ```sql
     select * from CLM_PAYMENT where <field> = '<value>';
     ```
   - Multiple values:
     ```sql
     select * from CLM_PAYMENT where <field> IN ('<value1>', '<value2>', '<value3>');
     ```

<!-- 4. **Copy to clipboard**: (DISABLED) Execute the copy command to copy SQL to clipboard:
   ```bash
   echo "SELECT * FROM CLM_PAYMENT WHERE <field> <operator> '<values>';" | pbcopy  # macOS
   # OR
   echo "SELECT * FROM CLM_PAYMENT WHERE <field> <operator> '<values>';" | clip   # Windows
   ``` -->

4. **Display the output** in code block format for easy copying

## Examples

**Example 1: Single UETR**
```
Input: generate CLM sql, UETR is 1234567890ABCDEF

Output:
-- CLM_PAYMENT
-- Conditions: uetr = '1234567890ABCDEF'

select * from CLM_PAYMENT where uetr = '1234567890ABCDEF';
```

**Example 2: Single transaction ID**
```
Input: generate sql, transaction_id is TX_12345

Output:
-- CLM_PAYMENT
-- Conditions: transaction_id = 'TX_12345'

select * from CLM_PAYMENT where transaction_id = 'TX_12345';
```

**Example 3: Multiple UETRs (IN clause)**
```
Input: generate CLM sql, UETR is 7f3e9a2c, 4b5d4e8a, 9c1d2f3a

Output:
-- CLM_PAYMENT
-- Conditions: uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a')

select * from CLM_PAYMENT
where uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a');
```

**Example 4: Multiple transaction IDs (semicolon separator)**
```
Input: generate sql, transaction_id is TX001;TX002;TX003

Output:
-- CLM_PAYMENT
-- Conditions: transaction_id IN ('TX001', 'TX002', 'TX003')

select * from CLM_PAYMENT
where transaction_id IN ('TX001', 'TX002', 'TX003');
```

**Example 5: Multiple UETRs (newline separated)**
```
Input: generate CLM sql, UETR is
7c9e6679-7425-40de-944b-e07fc1f90ae7
6ba7b810-9dad-11d1-80b4-00c04fd430c8
4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f

Output:
-- CLM_PAYMENT
-- Conditions: uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f')

select * from CLM_PAYMENT
where uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7',
              '6ba7b810-9dad-11d1-80b4-00c04fd430c8',
              '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f');
```

## Notes

- Always wrap values in single quotes
- Use lowercase field names (uetr, transaction_id)
- SQL statement should end with a semicolon
- If both UETR and transaction_id are provided, use AND in the WHERE clause
- For multiple values, use IN clause with comma-separated quoted values
- Supported separators: comma, space, semicolon, pipe, or newline
- **Code block output**: Always displayed in code blocks for easy copying in any environment
<!-- - **Auto-copy**: In environments that support clipboard access (like Claude Code), SQL is also automatically copied to clipboard (DISABLED) -->
