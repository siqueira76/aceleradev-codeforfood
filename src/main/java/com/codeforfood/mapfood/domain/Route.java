package com.codeforfood.mapfood.domain;

public class Route {

    private Position initialPosition;
    private Position middlePosition;
    private Position targetPosition;

    public Route(Position initialPosition, Position targetPosition, Position middlePosition) {
        this.initialPosition = initialPosition;
        this.middlePosition = middlePosition;
        this.targetPosition = targetPosition;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Position initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    public Position getMiddlePosition() {
        return middlePosition;
    }

    public void setMiddlePosition(Position middlePosition) {
        this.middlePosition = middlePosition;
    }
}
