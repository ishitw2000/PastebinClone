import React, { useEffect, useRef, useState } from "react";
import Options from "./Options";
import { connect } from "react-redux";
import * as actions from "../utils/actions";
import axios from "../utils/axios";

const Paste = (props) => {
  const [fontStyle, setFontStyle] = useState(props.selectedFont);
  const pasteBodyRef = useRef(null);
  const pasteTitleRef = useRef(null);

  useEffect(() => {
    setFontStyle(props.selectedFont);
  }, [props.selectedFont]);

  const handlePasteTitle = () => {
    props.setPasteTitleRedux(btoa(pasteTitleRef.current.value));
  };

  const handlePasteBody = () => {
    props.setPasteBodyRedux(btoa(pasteBodyRef.current.value));
  };

  const getData = () => {
    axios
      .get(`getPaste/${props.url}`)
      .then((res) => {
        if (res) {
          const data = atob(res.data.text);
          const title = atob(res.data.title);
          pasteBodyRef.current.value = data;
          pasteTitleRef.current.value = title;
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };
  if (props.disabled) getData();
  return (
    <div className="paste__main">
      <input
        className="paste__title"
        ref={pasteTitleRef}
        placeholder="Enter the title for the paste"
        style={{ fontFamily: `${fontStyle}` }}
        disabled={props.disabled}
        onChange={handlePasteTitle}
      />
      <textarea
        className="paste__body"
        placeholder="Enter your paste"
        typeof="text"
        ref={pasteBodyRef}
        cols={12}
        rows={23}
        style={{ fontFamily: `${fontStyle}` }}
        onChange={handlePasteBody}
        disabled={props.disabled}
      />
      <Options disabled={props.disabled} />
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    selectedFont: state.selectedFont,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    setPasteBodyRedux: (paste_body) =>
      dispatch({ type: actions.CHANGE_PASTE_BODY, paste_body: paste_body }),
    setPasteTitleRedux: (paste_title) =>
      dispatch({ type: actions.CHANGE_PASTE_TITLE, paste_title: paste_title }),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Paste);
