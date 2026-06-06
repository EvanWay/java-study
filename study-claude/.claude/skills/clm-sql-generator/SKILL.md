---
name: clm-sql-generator
description: Generate SQL queries for CLM_PAYMENT table based on UETR or transaction_id. Use this skill whenever the user asks to generate SQL for CLM tables, mentions UETR, needs to query CLM_PAYMENT, or wants to generate a where clause for CLM data lookup.
---

# CLM SQL Generator

Generate SQL queries for the CLM_PAYMENT table based on provided identifiers.

## When to Use

Use this skill when the user:
- Says "生成CLM的sql" or "生成sql"
- Mentions UETR or transaction_id in the context of CLM
- Asks to query CLM_PAYMENT table
- Needs to generate WHERE clauses for CLM lookups

## Supported Table

- **CLM_PAYMENT** - CLM Payment table

## Supported Fields

- **uetr** - UETR
- **transaction_id** - Transaction Id

## Output Format

Always display results in a clear, readable format:

```sql
-- CLM_PAYMENT
-- Conditions: uetr = 'xxx'

select * from CLM_PAYMENT where uetr = 'xxx';
```

## How to Generate SQL

1. **Identify the field** from user input:
   - "UETR是xxx" or "uetr是xxx" → field = `uetr`
   - "transaction id是xxx" or "transaction_id是xxx" → field = `transaction_id`

2. **Extract the value(s)** after "是" or "=" or ":"
   - Single value: `xxx` → use `= '<value>'`
   - Multiple values: `xxx, yyy, zzz` → use `IN ('xxx', 'yyy', 'zzz')`
   - Separators: comma (,), space, semicolon (;), or pipe (|)

3. **Construct the SQL**:
   - Single value:
     ```sql
     select * from CLM_PAYMENT where <field> = '<value>';
     ```
   - Multiple values:
     ```sql
     select * from CLM_PAYMENT where <field> IN ('<value1>', '<value2>', '<value3>');
     ```

4. **Copy to clipboard**: After displaying the SQL, copy the SQL statement (without comments) to clipboard using pbcopy (macOS) or clip (Windows)

5. **Display the output** in the clear format shown in examples

## Examples

**Example 1: UETR query**
```
Input: 生成CLM的sql，UETR是 1234567890ABCDEF

Output:
-- CLM_PAYMENT
-- Conditions: uetr = '1234567890ABCDEF'

select * from CLM_PAYMENT where uetr = '1234567890ABCDEF';
```

**Example 2: Transaction ID query**
```
Input: 生成sql，transaction_id是 TX_12345

Output:
-- CLM_PAYMENT
-- Conditions: transaction_id = 'TX_12345'

select * from CLM_PAYMENT where transaction_id = 'TX_12345';
```

**Example 3: Multiple UETRs (IN clause)**
```
Input: 生成CLM的sql，UETR是 7f3e9a2c, 4b5d4e8a, 9c1d2f3a

Output:
-- CLM_PAYMENT
-- Conditions: uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a')

select * from CLM_PAYMENT
where uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a');
```

**Example 4: Multiple transaction IDs (semicolon separator)**
```
Input: 生成sql，transaction_id是 TX001;TX002;TX003

Output:
-- CLM_PAYMENT
-- Conditions: transaction_id IN ('TX001', 'TX002', 'TX003')

select * from CLM_PAYMENT
where transaction_id IN ('TX001', 'TX002', 'TX003');
```

## Notes

- Always wrap the value in single quotes
- Use lowercase field names (uetr, transaction_id)
- The SQL statement should end with a semicolon
- If both UETR and transaction_id are provided, use AND in the WHERE clause
- For multiple values: use IN clause with comma-separated quoted values
- Supported separators for multiple values: comma, space, semicolon, pipe (|)
- **Auto-copy**: The SQL statement is automatically copied to clipboard for easy pasting
