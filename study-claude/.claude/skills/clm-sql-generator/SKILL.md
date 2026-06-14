---
name: clm-sql-generator
description: Generate SQL queries for CLM_PAYMENT, PAYMENT_MESSAGE_STATE, transaction_state, and process_state tables based on UETR or transaction_id. Use this skill whenever the user asks to generate SQL for CLM tables, mentions UETR, needs to query CLM_PAYMENT/PAYMENT_MESSAGE_STATE/transaction_state/process_state, or wants to generate a where clause for CLM data lookup.
---

# CLM SQL Generator

Generate SQL queries for CLM_PAYMENT, PAYMENT_MESSAGE_STATE, transaction_state, and process_state tables based on provided identifiers.

## When to Use

Use this skill when the user:
- Asks to generate SQL for CLM tables
- Mentions UETR or transaction_id in the context of CLM
- Asks to query CLM_PAYMENT, PAYMENT_MESSAGE_STATE, transaction_state, or process_state table
- Needs to generate WHERE clauses for CLM data lookup

## Supported Tables

- **CLM_PAYMENT** - CLM Payment table (supports uetr, transaction_id)
- **PAYMENT_MESSAGE_STATE** - Payment Message State table (with ORDER BY, supports uetr, transaction_id)
- **transaction_state** - Transaction State table (mini contract, with ORDER BY, supports uetr, transaction_id)
- **process_state** - Process State table (which service is failing, ONLY supports transaction_id)

## Supported Fields

- **uetr** - UETR
- **transaction_id** - Transaction ID

## Output Format

Always display results in code blocks for easy copying:

<!-- (auto-copy to clipboard disabled) -->

**For uetr:**
```sql
-- Conditions: uetr = 'xxx'

-- CLM_PAYMENT
select * from CLM_PAYMENT where uetr = 'xxx';

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where uetr = 'xxx'
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where uetr = 'xxx'
order by timestamp desc;
```

**For transaction_id:**
```sql
-- Conditions: transaction_id = 'xxx'

-- CLM_PAYMENT
select * from CLM_PAYMENT where transaction_id = 'xxx';

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where transaction_id = 'xxx'
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where transaction_id = 'xxx'
order by timestamp desc;

-- process_state (which service is failing)
select transaction_id,
       to_char(a.timestamp, 'YYYY-MM-DD hh24:mi:ss.ff3') datetime,
       regexp_substr(a.sequence, '[^,]+', 1, step+1) service,
       a.state, a.step, a.outcome, a.message
from process_state a
where transaction_id = 'xxx'
order by transaction_id, timestamp;
```

## How to Generate SQL

1. **Identify the field** from user input:
   - Keywords: "UETR", "uetr", "transaction_id", "transaction id" → determine the field
   - Look for values after "is", "=", ":", or "是" (for Chinese input)

2. **Extract the value(s)**:
   - Single value: `xxx` → use `= '<value>'`
   - Multiple values: `xxx, yyy, zzz` → use `IN ('xxx', 'yyy', 'zzz')`
   - Supported separators: comma (,), space, semicolon (;), pipe (|), or newline

3. **Construct the SQL** for ALL tables:

   **CLM_PAYMENT:**
   - Single value:
     ```sql
     select * from CLM_PAYMENT where <field> = '<value>';
     ```
   - Multiple values:
     ```sql
     select * from CLM_PAYMENT where <field> IN ('<value1>', '<value2>', '<value3>');
     ```

   **PAYMENT_MESSAGE_STATE** (always with ORDER BY):
   - Single value:
     ```sql
     select * from PAYMENT_MESSAGE_STATE
     where <field> = '<value>'
     order by transaction_id, timestamp asc;
     ```
   - Multiple values:
     ```sql
     select * from PAYMENT_MESSAGE_STATE
     where <field> IN ('<value1>', '<value2>', '<value3>')
     order by transaction_id, timestamp asc;
     ```

   **transaction_state** (always with ORDER BY):
   - Single value:
     ```sql
     select * from transaction_state
     where <field> = '<value>'
     order by timestamp desc;
     ```
   - Multiple values:
     ```sql
     select * from transaction_state
     where <field> IN ('<value1>', '<value2>', '<value3>')
     order by timestamp desc;
     ```

   **process_state** (ONLY supports transaction_id, always with ORDER BY):
   - Single value:
     ```sql
     select transaction_id,
            to_char(a.timestamp, 'YYYY-MM-DD hh24:mi:ss.ff3') datetime,
            regexp_substr(a.sequence, '[^,]+', 1, step+1) service,
            a.state, a.step, a.outcome, a.message
     from process_state a
     where transaction_id = '<value>'
     order by transaction_id, timestamp;
     ```
   - Multiple values:
     ```sql
     select transaction_id,
            to_char(a.timestamp, 'YYYY-MM-DD hh24:mi:ss.ff3') datetime,
            regexp_substr(a.sequence, '[^,]+', 1, step+1) service,
            a.state, a.step, a.outcome, a.message
     from process_state a
     where transaction_id IN ('<value1>', '<value2>', '<value3>')
     order by transaction_id, timestamp;
     ```

4. **Display the output** in code block format with:
   - Single `-- Conditions:` comment at the top
   - Followed by SQL for all applicable tables
   - **Important:** `process_state` is ONLY included when field is `transaction_id`

## Examples

**Example 1: Single UETR**
```
Input: generate CLM sql, UETR is 1234567890ABCDEF

Output:
-- Conditions: uetr = '1234567890ABCDEF'

-- CLM_PAYMENT
select * from CLM_PAYMENT where uetr = '1234567890ABCDEF';

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where uetr = '1234567890ABCDEF'
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where uetr = '1234567890ABCDEF'
order by timestamp desc;
```

**Example 1b: Single transaction ID (with process_state)**
```
Input: generate CLM sql, transaction_id is TX_12345

Output:
-- Conditions: transaction_id = 'TX_12345'

-- CLM_PAYMENT
select * from CLM_PAYMENT where transaction_id = 'TX_12345';

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where transaction_id = 'TX_12345'
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where transaction_id = 'TX_12345'
order by timestamp desc;

-- process_state (which service is failing)
select transaction_id,
       to_char(a.timestamp, 'YYYY-MM-DD hh24:mi:ss.ff3') datetime,
       regexp_substr(a.sequence, '[^,]+', 1, step+1) service,
       a.state, a.step, a.outcome, a.message
from process_state a
where transaction_id = 'TX_12345'
order by transaction_id, timestamp;
```

**Example 2: Multiple UETRs (IN clause)**
```
Input: generate CLM sql, UETR is 7f3e9a2c, 4b5d4e8a, 9c1d2f3a

Output:
-- Conditions: uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a')

-- CLM_PAYMENT
select * from CLM_PAYMENT
where uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a');

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a')
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where uetr IN ('7f3e9a2c', '4b5d4e8a', '9c1d2f3a')
order by timestamp desc;
```

**Example 3: Multiple transaction IDs (semicolon separator)**
```
Input: generate sql, transaction_id is TX001;TX002;TX003

Output:
-- Conditions: transaction_id IN ('TX001', 'TX002', 'TX003')

-- CLM_PAYMENT
select * from CLM_PAYMENT
where transaction_id IN ('TX001', 'TX002', 'TX003');

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where transaction_id IN ('TX001', 'TX002', 'TX003')
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where transaction_id IN ('TX001', 'TX002', 'TX003')
order by timestamp desc;

-- process_state (which service is failing)
select transaction_id,
       to_char(a.timestamp, 'YYYY-MM-DD hh24:mi:ss.ff3') datetime,
       regexp_substr(a.sequence, '[^,]+', 1, step+1) service,
       a.state, a.step, a.outcome, a.message
from process_state a
where transaction_id IN ('TX001', 'TX002', 'TX003')
order by transaction_id, timestamp;
```

**Example 4: Multiple UETRs (newline separated)**
```
Input: generate CLM sql, UETR is
7c9e6679-7425-40de-944b-e07fc1f90ae7
6ba7b810-9dad-11d1-80b4-00c04fd430c8
4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f

Output:
-- Conditions: uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f')

-- CLM_PAYMENT
select * from CLM_PAYMENT
where uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7',
              '6ba7b810-9dad-11d1-80b4-00c04fd430c8',
              '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f');

-- PAYMENT_MESSAGE_STATE
select * from PAYMENT_MESSAGE_STATE
where uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7',
              '6ba7b810-9dad-11d1-80b4-00c04fd430c8',
              '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f')
order by transaction_id, timestamp asc;

-- transaction_state (mini contract)
select * from transaction_state
where uetr IN ('7c9e6679-7425-40de-944b-e07fc1f90ae7',
              '6ba7b810-9dad-11d1-80b4-00c04fd430c8',
              '4e1c8c9e-6a3f-4b2a-9d5f-8e7a2c3b5d1f')
order by timestamp desc;
```

## Notes

- Always wrap values in single quotes
- Use lowercase field names (uetr, transaction_id)
- SQL statement should end with a semicolon
- For multiple values, use IN clause with comma-separated quoted values
- Supported separators: comma, space, semicolon, pipe, or newline
- **PAYMENT_MESSAGE_STATE** always includes `ORDER BY transaction_id, timestamp asc`
- **transaction_state** always includes `ORDER BY timestamp desc`
- **process_state** ONLY supports `transaction_id` field (NOT uetr), always includes `ORDER BY transaction_id, timestamp`
- **Code block output**: Always displayed in code blocks for easy copying in any environment
- **Output tables**:
  - `uetr`: CLM_PAYMENT + PAYMENT_MESSAGE_STATE + transaction_state (3 tables)
  - `transaction_id`: All 4 tables (including process_state)
- **Conditions header**: Single `-- Conditions:` comment at top, shared by all queries
<!-- - **Auto-copy**: In environments that support clipboard access (like Claude Code), SQL is also automatically copied to clipboard (DISABLED) -->
