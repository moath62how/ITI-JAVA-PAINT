---

# Java Paint Brush Application 🎨

A desktop-based Java application that replicates the functionality of basic paint tools. Developed as part of a team project, the application allows users to draw, color, erase, and save their artwork using various interactive components.

## 🧩 Features

This application was built using Java Swing (`JFrame`) and provides the following functionality:

- **Basic Drawing Tools**
  - Draw shapes: Rectangle, Oval, Line
  - Free-hand drawing
  - Eraser tool

- **Shape Customization**
  - Color buttons (Red, Green, Blue)
  - Color sliders (RGB)
  - Dotted or solid stroke option
  - Filled or outline shape option

- **Canvas Controls**
  - Clear All button
  - Undo last action
  - Save drawing to image file
  - Open existing image

## 👨‍💻 Team Members

- معاذ حسام عبدالغني مطر
- هبه الله عبدالباسط خضيري حسن
- ندى ياسر محمود محمد
- ياسمين ابراهيم محمد احمد

---

## ✅ Task Breakdown

### Tasks by **معاذ حسام عبدالغني مطر**
- Implemented **free-hand drawing**:
  - `StrokesShapeAction.java`, `Stroke.java`, modifications in `BodyCanvas.java`
- Developed the **Undo button**:
  - `UndoButtonActionListner.java`, modified `BodyCanvas.java`
- Added **Filled shapes** support:
  - `FilledCheckBox.java`, modified `BodyCanvas.java`
- Implemented **Open image** feature:
  - `OpenImageActionListner.java`
- Created **color sliders**:
  - `RedColorSlider.java`, `GreenColorSlider.java`, `BlueColorSlider.java`, modified `BodyCanvas.java`
- Set up the **main application launcher**:
  - `PaintAppInJava.java`
- Created a **custom data structure**:
  - `Pair.java`

### Tasks by **هبه الله عبدالباسط خضيري حسن**
- Developed deprecated **Color Buttons**:
  - `ColorsButtons.java`, `RedButton.java`, `GreenButton.java`, `BlueButton.java`, modified `BodyCanvas.java`
- Designed **Color Slider technique**:
  - `ColorSlider.java`
- Implemented **Save feature**:
  - `SaveAction.java`, modified `BodyCanvas.java`

### Tasks by **ندى ياسر محمود محمد**
- Added **Clear All button**:
  - `ClearAllAction.java`, modified `BodyCanvas.java`
- Implemented **Dotted shapes** feature:
  - `DottedCheckBox.java`, modified `BodyCanvas.java`

### Tasks by **ياسمين ابراهيم محمد احمد**
- Built **Shape selection system**:
  - `Line.java`, `Oval.java`, `Rectangle.java`
  - `LineShapeActionListener.java`, `OvalShapeActionListener.java`, `RectangleShapeActionListener.java`
  - `DrawingElement.java`, modified `BodyCanvas.java`
- Created **Eraser tool**:
  - `EraserButton.java`

---

## 🗂️ File Structure (Key Files)

```

├── PaintAppInJava.java          # Main launcher
├── BodyCanvas.java              # Core drawing canvas
├── StrokesShapeAction.java
├── Stroke.java
├── UndoButtonActionListner.java
├── FilledCheckBox.java
├── OpenImageActionListner.java
├── RedColorSlider.java / GreenColorSlider.java / BlueColorSlider.java
├── Pair.java                    # Custom data structure
├── SaveAction.java
├── ClearAllAction.java
├── DottedCheckBox.java
├── Line.java / Oval.java / Rectangle.java
├── LineShapeActionListener.java / OvalShapeActionListener.java / RectangleShapeActionListener.java
├── DrawingElement.java
├── EraserButton.java

```

## 📝 Project Goal

The goal of this project was to replicate the core functionalities of a basic paint application using Java and object-oriented principles. It was a practical exercise in UI design, event handling, and team collaboration.

---

## 📅 Deadline

Submitted by: **5 / 9 / 2024 at 11:59 a.m.**
```

