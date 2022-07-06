import './App.css';
import {useEffect, useState} from "react";
import Form from 'react-bootstrap/Form'
import {Button} from "react-bootstrap";

function App() {

    const [drivers, setDrivers] = useState([])
    useEffect(() => {
        fetch("http://localhost:8080/f1team/")
            .then(r => r.json())
            .then(data => setDrivers(data))
    }, [])
/*
    const [test, setTest] = useState([
        {firstName: "Heinz", lastName: "Smith", nationality: "Developer"},
        {firstName: "Martin", lastName: "Juan", nationality: "Teacher"},
        {firstName: "Santa", lastName: "Claus", nationality: "Deliverer"},
        {firstName: "Jean", lastName: "Dupont", nationality: "Detective"},
        {firstName: "Samantha", lastName: "Barbara", nationality: "Deliverer"},
        {firstName: "Deandrea", lastName: "Mcqueeney", nationality: "CEO"},
        {firstName: "Kit", lastName: "Rachal", nationality: "Unemployed"},
        {firstName: "Donnette", lastName: "Heiden", nationality: "Cooker"},
        {firstName: "Bill", lastName: "Bill", nationality: "Clown"}
    ])
*/
    const [pat, setPat] = useState("Verstappen");

    const filtered = drivers.filter(obj => {
        return obj.nachname === pat;
    });

    const [firstName,setFirstName] = useState("")
    const [lastName,setLastName] = useState("")
    const [year,setYear] = useState("")
    const [nationality,setNationality] = useState("")

    function buttonHandler(){
        let tmparray = [...drivers, {vorname: firstName, nachname: lastName,jahrgang: year, nationalitaet: nationality} ]
        setDrivers(tmparray)
    }


    return (
        <>
            <div className="App">
                <h1>F-1 Drivers</h1>
                <h3>Search by Last Name</h3>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Control type="text" value={pat} onChange={(event) => {
                            setPat(event.target.value)
                        }}/>
                    </Form.Group>
                </Form>

                {filtered.map(obj => {
                    return (
                        <div key={obj.id}>
                            <h4>First Name: {obj.vorname}</h4>
                            <h4>Last Name: {obj.nachname}</h4>
                            <h4>Year of Birth: {obj.jahrgang}</h4>
                            <h4>Nationality: {obj.nationalitaet}</h4>
                        </div>
                    );
                })}

                <Form>
                    <h1>add driver</h1>
                    <label>First Name</label>
                    <Form.Group className="mb-3" controlId="formBasicEmail" onChange={(event) => {
                        setFirstName(event.target.value)
                    }}>
                        <Form.Control type="text"/>
                    </Form.Group>
                    <label>Last Name</label>
                    <Form.Group className="mb-3" controlId="formBasicEmail" onChange={(event) => {
                        setLastName(event.target.value)
                    }}>
                        <Form.Control type="text"/>
                    </Form.Group>
                    <label>Year of Birth</label>
                    <Form.Group className="mb-3" controlId="formBasicEmail" onChange={(event) => {
                        setYear(event.target.value)}}>
                        <Form.Control type="number"/>
                    </Form.Group>
                    <label>Nationality</label>
                    <Form.Group className="mb-3" controlId="formBasicEmail" onChange={(event) => {
                        setNationality(event.target.value)
                    }}>
                        <Form.Control type="text"/>
                    </Form.Group>
                    <Button onClick={buttonHandler}>Submit</Button>
                </Form>
            </div>
        </>
    );
}

export default App;
