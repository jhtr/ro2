/**
 * Copyright (c) 2017, Arthur Godet, Joachim Hotonnier and Marie Deur. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 * See LICENSE file in the project root for full license information.
 */
package crossovers;

import definition.Crossover;
import definition.Solution;
import util.Random;

/**
 * The two-point crossover technique : version 1. Two cutting points are randomly taken. The child's
 * sequence between these two points is the same than its first parent's one. Then the child's
 * sequence is completed with jobs from the second parent, respecting the order of appearance 
 * in the sequence.
 * 
 * @author Arthur Godet
 * @author Joachim Hotonnier
 * @author Marie Deur
 * @since 19/03/2017
 */
public class TwoPointIn implements Crossover {

	/* (non-Javadoc)
	 * @see definition.Crossover#crossover(definition.Solution, definition.Solution)
	 */
	public Solution crossover(Solution parent1, Solution parent2) {
		Solution child = new Solution(parent1.getInstance());
		int[] cut = Random.randomTwoPoints(0, child.getInstance().getSize());

		child.copyRange(parent1, cut[0], cut[1]);
		child.merge(parent2);

		child.evaluate();
		return child;
	}
}
