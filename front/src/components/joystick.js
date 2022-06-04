import React ,{ useMemo, useRef, useState } from 'react';
import { Joystick } from 'react-joystick-component';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import zIndex from '@mui/material/styles/zIndex';

function GobeJoystickController({
    move,
    start,
    stop,
    opactiy = 1.0,
    className
  }) {
    const [containerDiv, setContainerDiv] = useState();
    // the container will always fill it's parent
    const containerStyle = useRef({
      width: "100%",
      height: "100%",
      display: "flex",
      alignItems: "center",
      justifyItems: "center",
      justifyContent: "center"
    }).current;
    const baseColor = useMemo(
      () =>
        `radial-gradient(circle at 50% 50%, rgba(100,100,100,${opactiy}), rgba(100,100,100,${opactiy}), rgba(100,100,100,${opactiy}),  rgba(5,5,5,${opactiy}))`,
      [opactiy]
    );
    const stickColor = useMemo(
      () =>
        `radial-gradient(circle at 50% 50%, rgba(70,70,70,${opactiy}), rgba(70,70,70,${opactiy}), rgba(5,5,5,${opactiy}))`,
      [opactiy]
    );
    return (
      <div ref={setContainerDiv} style={containerStyle} className={className}>
        {containerDiv ? (
          <Joystick
            // we are assuming that the container dimensions will never change in the lifetime of this component
            size={Math.min(containerDiv.offsetWidth, containerDiv.offsetHeight)}
            baseColor={baseColor}
            stickColor={stickColor}
            throttle={200}
            move={move}
            stop={stop}
            start={start}
          />
        ) : null}
      </div>
    );
  }
  








export default function JoystickComp(){
    const handleMove = (e) => {
        let x = e.x/50
        let y = e.y/50
        if(e.direction==="BACKWARD" ||e.direction==="FORWARD"){
            console.log("UP or DOWN (" +x+','+y+')');
        }else{
            console.log("LEFT or RIGHT (" +x+','+y+')');
        }
      };
      const handleStop = (e) => {
        console.log("STOP");
      };
      const handleStart = (e) => {
        console.log("START");
      };
    
// return(<Joystick start={action("Started")} controlPlaneShape={JoystickShape.Square} move={action("Moved")}
// stop={action("Stopped")}/>)
return(
    <Box sx={{
        minWidth : 400,
        minHeight: 250,
        backgroundColor: '#e5d5d3',
        opacity:0.9,
        '&:hover': {
          backgroundColor: '#e5d5d3',
          opacity: [0.9, 0.8, 0.9],
        },
        }} stylr={{display:'flex', justifyContent:'center'}}>
         
              <Slider
              style={{position:'absolute',left:'0%' ,bottom:'11%' , height:'80%'}}
                orientation='vertical'
                aria-label="joystick"
                defaultValue={0}
                valueLabelDisplay="auto"
                min={0}
                step={0.01}
                max={1}
                onChange={(e)=>console.log(e.target.value)}
                />
        <div style={{position:'absolute' , left:'40%',bottom:'40%'}}>
            <GobeJoystickController
            opactiy={1}
            move={handleMove}
            stop={handleStop}
            start={handleStart}
            />
        </div>
        <Slider
            style={{position:'absolute',left:'10%' ,bottom:'5%',width:'80%'}}
                aria-label="joystick"
                defaultValue={0}
                valueLabelDisplay="auto"
                onChange={(e)=>console.log(e.target.value)}
                min={0}
                step={0.01}
                max={1}
            />
    </Box>
);

}