package progfun.utils

import progfun.models.Lawnmower

object ListComparator {
  def areLawnmowerListsEqual(firstList: List[Lawnmower], secondList: List[Lawnmower]): Boolean = {
    (firstList, secondList) match {
      case (thisLawnmower :: thisLawnmowerRest, other :: otherRest) => {
        if (thisLawnmower.equals(other)) {
          thisLawnmower.equals(other) && areLawnmowerListsEqual(thisLawnmowerRest, otherRest)
        }
        else {
          false
        }
      }
      case (Nil, Nil) => {
        true
      }
      case (List(_), Nil) => false
      case (Nil, List(_)) => false
    }
  }
}
