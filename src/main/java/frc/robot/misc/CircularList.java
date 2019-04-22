/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.misc;

import java.util.ArrayList;

public class CircularList<E> extends ArrayList<E> {
	public static final long serialVersionUID = 1L;
	private int index = 0;

	@SafeVarargs
	public CircularList(E... initVals) {
		super();
		this.addAll(initVals);
	}

	public E get() {
		return get(index);
	}

	public E next() {
		if (++index == size())
			index = 0;
		return get(index);
	}

	public E prev() {
		if (--index == size())
			index = size() - 1;
		return get(index);
	}

	public void addAll(E[] arr) {
		for (E e : arr)
			add(e);
	}

	@Override
	public void add(int index, E e) {
		super.add(index, e);
		if (this.index >= index)
			this.index++;
	}

	@Override
	public E remove(int index) {
		E e = super.remove(index);
		if (this.index >= index && index != 0)
			index--;
		return e;
	}
}