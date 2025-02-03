from sqlalchemy.orm import Session
from sqlalchemy import select
from database.connection import SessionFactory
from database.orm import ToDo
session = SessionFactory()
print(session.scalars(select(ToDo).order_by(ToDo.id)).all())
session.close()