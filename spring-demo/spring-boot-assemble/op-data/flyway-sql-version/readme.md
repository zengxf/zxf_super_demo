# Flyway demo

## 版本规范
- `V1.0.0__xx-yy.sql`
- `V1.2.2__xx-yy.sql`

## 关键表
- `flyway_schema_history` 不能删
  - 删了会重新执行所有 *.sql