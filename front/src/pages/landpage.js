
import Sidebar from "../components/nav-bar/nav_bar"
export default function LandingPage(){


    return(   
        <div>
            <Sidebar />
            <div style={{position :'absolute' , left:'50%', top :'20%'}}> 
        <h1 style={{position :'relative' , top :'-100%'}}> Flight Gear Project</h1>
        <ul>
            <li>Daniel Ohayon </li>
            <li>Alon Manshari </li>
            <li>Rom Bardugo </li>
            <li>Shon Hazan </li>
            <li>Jony Singer </li>
        </ul>
        </div>
    </div>
)

}