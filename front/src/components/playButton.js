import { Button } from "@mui/material";
import React from "react";

export default function OnlyPlayPauseButton(props) {
  function handlePlay() {
    props.setIsPlaying(true);
    props.setIsPlaying(true);
    console.log(props.isPlaying);
  }

  function handlePause() {
    props.setIsPlaying(false);
    console.log(props.isPlaying);
  }

  return (
    <div>
      <Button
        style={{ fontSize: "15px", color: "#000080" }}
        onClick={handlePlay}
      >
        Play /
      </Button>
      <Button
        style={{ fontSize: "15px", color: "#000080" }}
        onClick={handlePause}
      >
        Pause
      </Button>
    </div>
  );
}
