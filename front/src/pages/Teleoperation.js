import Sidebar from "../components/nav-bar/nav_bar"
import JoystickComp from "../components/joystick"
import Form from 'react-bootstrap/Form'
import FloatingLabel from 'react-bootstrap/FloatingLabel'
export default function Teleoperation (){
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
            <Form.Text id="inputText" >
                Your Code must be compatible with the language of Simulator. 
            </Form.Text>
        </div>
        <div  style={{position:'absolute' , left:'45%',top:'37%' }}>
            <JoystickComp />
        </div>
    </div>);
}