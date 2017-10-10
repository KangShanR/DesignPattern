/**
 * @author Administrator
 * 此包是java设计模式中命令模式的简单示例的包
 * 命令模式：将执行的命令串成一个命令链条，最终通过执行命令链条所有命令来实现命令的执行
 * 实现方式：通过将所有命令类都实现同一个接口，而将实现的命令对象add到一个此接口的集合中（比如：List），
 * 	而执行命令就通过遍历这个集合，让集合中每一个对象进行执行接口方法
 * 
 * 这个示例是通过经纪人将买卖股票的命令放入到经纪人对象中的List中，再遍历这个List中的对象，对象都执行其中的方法而实现将命令执行
 * 在命令模式中，只要想将新的命令加入到这个命令链条中，只要将新的命令类实现这个Order接口就行。
 * 	在这个示例中也是同样的，想将一个不相干的命令（可以是创建一个对象，也可以是随便打印一句话）
 * 	加入到最终执行链条中，将这个命令的类实现Order接口就可以。
 * 当然在这个示例中如果另外一个命令只是想买卖股票，只需要new一个新的BuyStock、SellStock对象即可；
 */
package designpattern.commandpattern;