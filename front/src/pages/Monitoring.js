import Sidebar from "../components/nav-bar/nav_bar"
import VirtualizedList from "../components/VirtualizedList"
import { BarChart } from "../components/barChart"
import { Joystick } from "react-joystick-component"
import JoystickComp from "../components/joystick"
import LineChartMonitoring from "../components/lineChartMonitoring"
import Speedometer from "../components/clocks/speedometer"
import Direction from "../components/clocks/direction"
import VerticalSpeed from "../components/clocks/verticalSpeed"
import Height from "../components/clocks/height"
import Horizon from "../components/clocks/horizon"
import Turn from "../components/clocks/turn"
import {useState,useEffect} from "react"

export default function Monitoring (){
    const [value,setValue]=useState('')
   const SET = (val) => { 

        setValue(val) 
      }
      useEffect(() => {
        console.log(value)
      },[value])
    return (<div >
         <Sidebar />
        <h1 style={{position:'absolute',left:'40%' , top:'10%'}}> Monitoring {value }</h1>
        <div style={{backgroundColor:'white'}}>
        <div style={{position:'absolute' , left:'25%',top:'25%' }}>
            <VirtualizedList setValue={SET}/>
            
        </div>
        <div style={{position:'absolute' , left:'78%', right:'0%',top:'30%' ,width:'20vw'}}>
            {/* <h1>Joystick</h1> */}
            <JoystickComp />
            {/* <Joystick /> */}
            
        </div>
        <div style={{position:'absolute' , left:'40%',top:'25%' ,width:'35vw'}}>
            <LineChartMonitoring />
        </div>
        <div style={{display: 'grid',gridTemplateColumns:'auto auto auto',gap:'20px',padding:'10px',margin:'35px', position:'absolute' , left:'35%',top:'60%' ,width:'35vw'}}>
                <b style={{textAlign:'center'}}>Speed<Speedometer /> </b>
                <b style={{textAlign:'center'}}>Height<Height/> </b>
                <b style={{textAlign:'center'}}>Horizon<Horizon /> </b>
                <b style={{textAlign:'center'}}>Direction<Direction /> </b>
                <b style={{textAlign:'center'}}>Turn<Turn /> </b>
                <b style={{textAlign:'center'}}>Vertical speed<VerticalSpeed /> </b>
            </div>

        </div>
    </div>)
}