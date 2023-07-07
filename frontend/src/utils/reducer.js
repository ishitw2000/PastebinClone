import * as actions from "./actions";

const initialState = {
  title: null,
  body: null,
  selectedFont: "Arial",
};

const appReducer = (state = initialState, action) => {
  switch (action.type) {
    case actions.CHANGE_FONT_STYLE:
      return {
        ...state,
        selectedFont: action.font_style,
      };
    case actions.CHANGE_PASTE_BODY:
      return {
        ...state,
        body: action.paste_body,
      };
    case actions.CHANGE_PASTE_TITLE:
      return {
        ...state,
        title: action.paste_title,
      };
    default:
      return state;
  }
};

export default appReducer;
