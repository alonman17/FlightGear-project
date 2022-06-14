import Sidebar from "../components/nav-bar/nav_bar"
import VirtualizedList from "../components/listOfFeatures"
import { BarChart } from "../components/barChart"
import { Joystick } from "react-joystick-component"
export default function Monitoring (){
    return (<div >
         <Sidebar />
        <h1 style={{position:'absolute',left:'40%' , top:'10%'}}> Monitoring</h1>
        <div style={{position:'absolute' , left:'25%',top:'25%' }}>
            <VirtualizedList /> 
        </div>
        <div style={{position:'absolute' , right:'10%',top:'25%' ,width:'40vw'}}>
            <Joystick />
        </div>
    </div>)
}