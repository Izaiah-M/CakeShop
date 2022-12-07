from cs50 import SQL
import random

db = SQL("sqlite:///CakeShop.db")

types = ["Fruit Cake","Forest Cake","Sponge Cake","Basic Vanilla Cake"]
Flavours = ["orange","marble","chocolate","vanilla"]
icings = ["fondant","Whipped Cream","Butter Cream"]
date = "6/12/2022"

for i in range(0,50):
    price = random.randrange(50000,1000000,100000)
    type = random.choice(types)
    flavour = random.choice(Flavours)
    icing = random.choice(icings)
    
    db.execute("INSERT INTO Cakes(Type,Flavour,DateMade,Icing,Cost) VALUES(?,?,?,?,?);",type,flavour,date,icing,price)