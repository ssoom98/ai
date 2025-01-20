from pydantic import BaseModel

class ToDoRequest(BaseModel):
    id : int
    contents : str
    is_done : bool | None=False
