# pip install jinja2
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from fastapi import Request
from pydantic import BaseModel
from fastapi import Form

app = FastAPI()
templates = Jinja2Templates(directory="templates")
app.mount("/static", StaticFiles(directory="static"),name="static")

@app.get('/')
@app.get('/html1')
async def html1(request:Request):
    return templates.TemplateResponse("ex3_1.html".{'request':request})