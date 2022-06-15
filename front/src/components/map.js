import { useState } from 'react'
import {
  MapContainer,
  Marker,
  Popup,
  TileLayer,
  useMapEvents,
} from 'react-leaflet'
import L from 'leaflet';
import { Link } from 'react-router-dom';
import AirplanemodeActiveIcon from '@mui/icons-material/AirplanemodeActive';
import { renderToStaticMarkup } from "react-dom/server";
import 'leaflet/dist/leaflet.css';

const iconMarkup = renderToStaticMarkup(
    <AirplanemodeActiveIcon  style={
      {position: 'relative' , opacity:'0.7' ,  fontSize:'38px',left:'0.0rem'  , top:'0.0rem'}} /> 
  );

const aircrafts = [{'name' : 'a','yaw' :270, 'height': 20000 , 'speed':100,'position':{'lat':51.505,'long': -0.09}},{'name' : 'b','yaw' :110, 'height': 20000 , 'speed':100,'position':{'lat':51.509,'long': -0.1}},{'name' : 'c','yaw' :10, 'height': 20000 , 'speed':100,'position':{'lat':51.502,'long': -0.08}}]

function aircraftPosition(position) {
   
    let res = [] 
    res.push(parseFloat(position.lat))
    res.push(parseFloat(position.long))
    return res

}



function Map() {

    const MarkersLists = (props) => { 
      const AllairCrafts= props.data
        return (
            <div>
              {
                    AllairCrafts.map(aircraft => (
                        <div key={aircraft.name}>
                            <Marker eventHandlers={{
                                click: (e) => {
                                    // this.props.history.push("/monitoring")
                                },
                                dblclick:(e)=>{
                                  //  <Link to={'/monitoring/2'}></Link>
                                }
                            }} position={aircraftPosition(aircraft.position)} icon={L.divIcon({
                                className: "my-custom-pin",
                                html:`<div style="transform:rotate(${aircraft.yaw}deg);">${iconMarkup} </div>`
                            })} >
                                <Popup  ><div>
                                            <ul style={{fontSize:'20px',position:'relative' ,marginLeft:'-2vw'}}>
                                                <li>Name:{aircraft.name} </li>
                                                <li>Yaw:{aircraft['vertical-speed-fps']} </li>
                                                <li>Speed:{aircraft['vertical-speed-fps']} </li>
                                                <li>Height:{aircraft['vertical-speed-fps']} </li>
                                            </ul>
                                    </div></Popup>
                            </Marker>
                        </div>
                    ))
                }
            </div>)


// visibility:${AdminClick && cartClick ===cartInfo.cart_number  ? "none" : "hidden" }; font-size:1em;">`
    }









  return (
    <MapContainer center={{ lat: 51.505, lng: -0.09 }} zoom={13}>
      <TileLayer
        attribution=''
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <MarkersLists />
    </MapContainer>
  )
}
export default Map