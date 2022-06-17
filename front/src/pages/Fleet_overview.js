import Sidebar from "../components/nav-bar/nav_bar"
import Map from "../components/map"
import axios from 'axios'
import KPI from "../components/kpi"

import { useContext, useEffect , useState} from "react";
export default function FleetOverview (){

    const [data ,setData] = useState(null);
    const getData = async () =>{
        axios.get('/api/liveFlights/test/all').then(res=>{
           setData(res.data)
        })
        
    }
    getData()
    // useEffect(()=>{
    //     getData()
    // },[])


    return (<div >
    <Sidebar />
  
   <h1 style={{position:'absolute',left:'45%' , top:'5%',fontSize:'2.4rem'}}> Fleet Overview</h1>
    <div style={{position:'absolute' , left:'17%',top:'17%' }}>
        <h2 style={{position:'relative' , left:'11vw',top:'-7vh',fontSize:'2.2rem' }}>Live Air-Crafts Map</h2>
       {data && <Map data={data}  />}
    </div>
    <div style={{position:'absolute' , right:'0%',top:'17%' ,width:'40vw'}}>
        <h2 style={{position:'relative' , right:'-10vw',top:'-7vh',fontSize:'2.2rem' }}>KPI</h2>
        <KPI />
    </div>
</div>)
}