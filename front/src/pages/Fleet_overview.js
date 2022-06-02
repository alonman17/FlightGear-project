import Sidebar from "../components/nav-bar/nav_bar"
import Map from "../components/map"

export default function FleetOverview (){
    return (<div >
    <Sidebar />
   <h1 style={{position:'absolute',left:'45%' , top:'5%',fontSize:'2.4rem'}}> Fleet Overview</h1>
    <div style={{position:'absolute' , left:'17%',top:'17%' }}>
        <h2 style={{position:'relative' , left:'11vw',top:'-7vh',fontSize:'2.2rem' }}>Live Air-Crafts Map</h2>
        <Map  />
    </div>
    <div style={{position:'absolute' , right:'0%',top:'17%' }}>
        <h2 style={{position:'relative' , right:'15vw',top:'-7vh',fontSize:'2.2rem' }}>KPI</h2>

    </div>
</div>)
}