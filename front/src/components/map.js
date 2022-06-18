import React , { useState } from 'react'
import {
  MapContainer,
  Marker,
  Popup,
  TileLayer,
  useMapEvents,
} from 'react-leaflet'
import { Redirect } from 'react-router-dom';
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



function Map(props) {
  const Obj = props.data
  const AllairCrafts= Object.keys( props.data)
  console.log(Obj) 
  console.log(AllairCrafts)
    const MarkersLists = () => { 
        return (
            <div>
              {
                    AllairCrafts.map((id) => (
                        <div key={id}>
                            <Marker eventHandlers={{
                             dblclick:()=>{ window.location.href =`http://localhost:3000/monitoring/${id}` }
                            }} position={aircraftPosition({'lat':Obj[`${id}`]['values']['latitude-deg'],'long':Obj[`${id}`]['values']['longitude-deg']})} icon={L.divIcon({
                                className: "my-custom-pin",
                                html:`<div style="transform:rotate(${Obj[`${id}`]['values']['latitude-deg']}deg);">${iconMarkup} </div>`
                            })} >
                                <Popup  ><div>
                                            <ul style={{fontSize:'20px',position:'relative' ,marginLeft:'-2vw'}}>
                                                <li>Name:{id} </li>
                                                <li>Yaw:{Obj[id]['values']['latitude-deg']} </li>
                                                <li>Speed:{Obj[`${id}`]['values']['airspeed-kt']} </li>
                                                <li>Height:{Obj[`${id}`]['values']['altitude-ft']} </li>
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
    <MapContainer center={{ lat: 63.991836228, lng:  -22.6054263253 }} zoom={13}>
      <TileLayer
        attribution=''
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <MarkersLists />
    </MapContainer>
  )
}
export default React.memo( Map)