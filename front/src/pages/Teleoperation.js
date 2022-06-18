import { useState } from "react"
import Sidebar from "../components/nav-bar/nav_bar"
import JoystickComp from "../components/joystick"
import {useParams} from "react-router-dom";
import Form from 'react-bootstrap/Form'
import FloatingLabel from 'react-bootstrap/FloatingLabel'
import { Button } from "@mui/material";
import axios from "axios"
export default function Teleoperation (){
    const { id } = useParams();//air-craft id 
    const [code,setCode]=useState('')
    const sendSimCode = ()=>{
    axios.post(`/api/liveFlights/${id}`).then(alert("send code !"))
    }
    return (<div >
        <Sidebar />
        <h1 style={{position:'absolute',left:'40%' , top:'10%'}}> Teleoperation</h1>
        <div style={{position:'absolute' , left:'32%',top:'37%' ,width:'200px',minHeight:'200px' }}>
            <Form.Label htmlFor="input5">Code :</Form.Label>
            <FloatingLabel controlId="floatingTextarea2"  label="Simulator Code">
                <Form.Control
                as="textarea"
                placeholder="Leave a comment here"
                style={{ minHeight: '130px',width:'300px' }}
                />
            </FloatingLabel>
            <Form.Text id="inputText" onChange={(e)=>setCode(e.target)} >
                Your Code must be compatible with the language of Simulator. 
            </Form.Text>
            <Button style={{position:'relative' , left:'8vw'}} size="large" onClick={sendSimCode} color="secondary">submit</Button>
        </div>
        <div  style={{position:'absolute' , left:'45%',top:'37%' }}>
            <JoystickComp />
        </div>
    </div>);
}