import './App.css';
import {useState} from "react";
import Form from 'react-bootstrap/Form'

function App() {

    const drivers = [
        {firstName: "Heinz", lastName: "Smith", nationality: "Developer"},
        {firstName: "Martin", lastName: "Juan", nationality: "Teacher"},
        {firstName: "Santa", lastName: "Claus", nationality: "Deliverer"},
        {firstName: "Jean", lastName: "Dupont", nationality: "Detective"},
        {firstName: "Samantha", lastName: "Barbara", nationality: "Deliverer"},
        {firstName: "Deandrea", lastName: "Mcqueeney", nationality: "CEO"},
        {firstName: "Kit", lastName: "Rachal", nationality: "Unemployed"},
        {firstName: "Donnette", lastName: "Heiden", nationality: "Cooker"},
        {firstName: "Bill", lastName: "Bill", nationality: "Clown"}
    ]

    const [pat, setpat] = useState("Smith");

    const filtered = drivers.filter(obj => {
        return obj.lastName === pat;
    });


    return (
        <>
            <div className="App">
                <h1>F-1 Drivers</h1>
                <h3>Search by Last Name</h3>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Control type="text" value={pat} onChange={(event) => {
                            setpat(event.target.value)
                        }}/>
                    </Form.Group>
                </Form>


                {filtered.map(obj => {
                    return (
                        <div key={obj.id}>
                            <h4>First Name: {obj.firstName}</h4>
                            <h4>Last Name: {obj.lastName}</h4>
                            <h4>Nationality: {obj.nationality}</h4>
                        </div>
                    );
                })}

            </div>
        </>
    );
}

export default App;
