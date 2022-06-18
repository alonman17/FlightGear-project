import Sidebar from "../components/nav-bar/nav_bar"
import Map from "../components/map"
import axios from 'axios'
import KPI from "../components/kpi"

import { useContext, useEffect , useState} from "react";

const mo = [
               {
                   aircraftId: 1,
                  millagedone: 600
              }
          ,
              {
                  aircraftId: 4,
                 millagedone: 100
             }
         ,
            {
                 aircraftId: 5,
                millagedone: 500
            }
        ];
const obj={1:600,4:100,5:500}
const ye=  {
       "1": 0.0,
       "2": 0.6,
       "3": 0.6,
       "4": 0.2,
       "5": 0.0,
       "6": 0.0028126483769211107,
       "7": 0.0,
       "8": 0.0,
       "9": 0.0,
       "10": 0.0,
       "11": 0.0,
       "12": 0.0
     }
const si =  {
       "1": 0,
       "2": 1,
      "3": 2,
       "4": 2,
       "5": 3,
       "6": 4,
       "7": 4,
       "8": 4,
       "9": 5,
       "10": 6,
        "11": 6,
       "12": 7
     }






export default function FleetOverview (){

    const [AllairCraft ,setAllairCraft] = useState(null);
    const [perAircraft ,setperAircraft] = useState(null);
    const [milesperAircraft ,setmilesperAircraft] = useState(null);
    const [milesallfleet ,setmilesallfleet] = useState(null);
    const [fleetSizeArr , setfleetSizeArr] =  useState(null)
    let i=0
    const getData = () =>{
        const month = new Date().getMonth()
        const year = new Date().getFullYear()
        axios.get('/api/liveFlights/test/all',{mode: 'no-corsx'}).then(res=>{
            setAllairCraft(res.data)
         
        })
        axios.get('/api/statistics/liveFlightsCount').then(res=>{
            let live = res.data
            axios.get(`api/statistics/fleetSize/${year}`).then(res=>{
                setfleetSizeArr(res.data)
                 setperAircraft(live/res.data)
                // setperAircraft(0.6)
             })
         })
         
         axios.get(`/api/statistics/aircraft/all/${month}`).then(res=>{
            let arr= res.data
            // arr.sort((a,b) => (a.millagedone > b.millagedone) ? 1 : ((b.millagedone > a.millagedone) ? -1 : 0))
            let Obj= {}
            for(let ob in arr){
                Obj[ob.id] =ob.millagedone
            }
            setmilesperAircraft(Obj)
            // setmilesperAircraft(mo)
         })
         axios.get(`/api/statistics/aircraft/${year}`).then(res=>{
            setmilesallfleet(res.data)
           //setmilesallfleet(ye)
         })
    }


    useEffect(()=>{
        if(i===0){
            i=1;
            getData()
        };
    },[])


    return (<div >
    <Sidebar />
  
   <h1 style={{position:'absolute',left:'45%' , top:'5%',fontSize:'2.4rem'}}> Fleet Overview</h1>
    <div style={{position:'absolute' , left:'17%',top:'17%' }}>
        <h2 style={{position:'relative' , left:'11vw',top:'-7vh',fontSize:'2.2rem' }}>Live Air-Crafts Map</h2>
       {AllairCraft && <Map data={AllairCraft} />}
    </div>
    <div style={{position:'absolute' , right:'0%',top:'17%' ,width:'40vw'}}>
        <h2 style={{position:'relative' , right:'-10vw',top:'-7vh',fontSize:'2.2rem' }}>KPI</h2>
        {milesperAircraft &&<KPI fleetSize={fleetSizeArr} percent={perAircraft} miles_air={milesperAircraft} miles_all={milesallfleet} />}
    </div>
</div>)
}