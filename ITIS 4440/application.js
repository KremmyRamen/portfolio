const express = require("express");
const fs = require("fs");
const app = express();
const port = 8084;

app.use(express.urlencoded({
    extended: true
}));
app.use(express.json());

app.post("/create", (req, res) => {
    const persons = require("./person");

    if (req.body.firstname == null || req.body.lastname == null || req.body.age == null || req.body.gender == null || req.body.major == null || req.body.concentration == null || req.body.hometown == null || req.body.favoritecolor == null) {
        res.status(400).send("Please enter correct body for your person.");

    } else {
        let person = {
            "firstname": req.body.firstname,
            "lastname": req.body.lastname,
            "age": req.body.age,
            "gender": req.body.gender,
            "major": req.body.major,
            "concentration": req.body.concentration,
            "hometown": req.body.hometown,
            "favoritecolor": req.body.favoritecolor
        };
        persons.push(person);

        fs.writeFile("person.json", JSON.stringify(persons), err => {
            if (err)
                throw err;
            res.send("Successfully created profile for " + person.firstname + "!")
        });
    }
});
app.get("/list", (req, res) => {
    const person = require("./person");
    res.send(person);
});

app.get("/list2", (req, res) => {
    const persons = require("./person");
    if (req.query.age == null && req.query.gender == null) {
        res.send(persons);
    } else {
        var response = [];
        persons.forEach(person => {
            console.log(person.gender + " " + req.query.gender);
            if (parseInt(person.age) == parseInt(req.query.age)) {
                response.push(person);

            } else if (person.gender == req.query.gender) {
                response.push(person);
            }
        });
        res.send(response);
    }
});

app.get("/list3", (req, res) => {
    const persons = require("./person");
    if (req.query.oldest == null && req.query.youngest == null) {
        res.send("Enter a valid number");
    } else {
        var response = [];
        persons.forEach(person => {
            if (parseInt(person.age) <= req.query.oldest && parseInt(person.age) >= req.query.youngest) {
                response.push(person);
            }
        });
        res.send(response);
    }
});

app.listen(port, () => {
    console.log("Example app listening on port " + port);
})