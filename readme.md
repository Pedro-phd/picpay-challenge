### Database

- Table: Costumers
    - id: uuid primary
    - name: string
    - email: string, unique
    - password: string
    - document_number: string, unique
    - document_type: string
    - costumer_type: string

- Table: Wallets
    - id: uuid primary
    - costumer_id: uuid
    - amount: int
