Category  | Recipe                                                         | XPath (1.0 – 2.0) | CSS (CSS1 – 3)
--- |----------------------------------------------------------------| --- | ---
General | Whole web page                                                 | xpath=/html | html
General | 	Whole web page body                                           | xpath=/html/body | body
General | 	All text nodes of web page                                    | //text() |
General | 	Element <E> by absolute reference                             | xpath=/html/body/.../.../.../E | body>…>…>…>E
Tag | Element <E> by relative reference                              | //E | E
Tag | 	Second <E> element anywhere on page                           | xpath=(//E)[2] |
Tag | 	Image element                                                 | //img | img
Tag | 	Element <E> with attribute A                                  | //E[@A] | E[A]
Tag | 	Element <E> with attribute A containing text 't' exactly      | //E[@A='t'] | E[A='t']
Tag | 	Element <E> with attribute A containing text 't'              | //E[contains(@A,'t')] | E[A*='t']
Tag | 	Element <E> whose attribute A begins with 't'                 | //E[starts-with(@A, 't')] | E[A^='t']
Tag | 	Element <E> whose attribute A ends with 't'                   | //E[substring(@A, string-length(@A) - string-length('t')+1)='t'] | E[A$='t']
Tag | 	Element <E> with attribute A containing word 'w'              | //E[contains(concat('⦿', @A, '⦿'), '⦿w⦿') | E[A~='w']
Tag | 	Element <E1> with id I1 or element <E2> with id I2            | //E1[@id=I1] | //E2[@id=I2] | E1#I1,E2#I2
Tag | 	Element <E1> with id I1 or id I2                              | //E1[@id=I1 or @id=I2] | E1#I1,E1#I2
Attribute | Attribute A of element <E>                                     | //E/@A | NA {Se: E@A }
Attribute | 	Attribute A of any element                                    | //*/@A | NA {Se: *@A }
Attribute | 	Attribute A1 of element <E> where attribute A2 is 't' exactly | //E[@A2='t']/@A1 | NA {Se: E[A2='t']@A1 }
Attribute | 	Attribute A of element <E> where A contains 't'               | //E[contains(@A,'t')]/@A | NA {Se: E[A*='t']@A }
Id & Name | Element <E> with id I                                          | //E[@id='I'] | E#I
Id & Name | 	Element with id I                                             | //*[@id='I'] | #I
Id & Name | Element <E> with name N                                        | //E[@name='N'] | E[name=N]
Id & Name | 	Element with name N                                           | //*[@name='N'] | [name=N]
Id & Name | Element with id X or, failing that, a name X                   | //*[@id='X' or @name='X'] |
Id & Name | Element with name N & specified 0-based index ‘v’              | //*[@name='N'][v+1] | [name=N]:nth-child(v+1)
Id & Name | Element with name N & specified value ‘v’                      | //*[@name='N'][@value='v'] | [name=N][value='v’]
Lang & Class | Element <E> is explicitly in language L or subcode             | //E[@lang='L' or starts-with(@lang, concat('L', '-'))] | E[lang|=L]
Lang & Class | Element <E> is in language L or subcode (possibly inherited)   |  | E:lang(L)
Lang & Class | 	Element with a class C                                        | //*[contains(concat('⦿', @class, '⦿'), '⦿C⦿')] | .C
Lang & Class | 	Element <E> with a class C                                    | //E[contains(concat('⦿', @class, '⦿'), '⦿C⦿')] | E.C
Text & Link | Element containing text 't' exactly                            | //*[.='t'] |
Text & Link | 	Element <E> containing text 't'                               | //E[contains(text(),'t')] | E:contains('t')
Text & Link | 	Link element                                                  | //a | a
Text & Link | 	\<a> containing text 't' exactly                              | //a[.='t'] |
Text & Link | \<a> containing text 't'                                       | //a[contains(text(),'t')] | a:contains('t')
Text & Link | \<a> with target link 'url'                                    | //a[@href='url'] | a[href='url']
Text & Link | 	Link URL labeled with text 't' exactly                        | //a[.='t']/@href |
Parent & Child | First child of element <E>                                     | //E/*[1] | E > *:first-child
Parent & Child | 	First <E> child                                               | //E[1] | E:first-of-type
Parent & Child | Last child of element E                                        | //E/*[last()] | E *:last-child
Parent & Child | 	Last <E> child                                                | //E[last()] | E:last-of-type
Parent & Child | 	Second <E> child                                              | //E[2] ◄OR► //E/following-sibling::E | E:nth-of-type(2)
Parent & Child | 	Second child that is an <E> element                           | //*[2][name()='E'] | E:nth-child(2)
Parent & Child | 	Second-to-last <E> child                                      | //E[last()-1] | E:nth-last-of-type(2)
Parent & Child | 	Second-to-last child that is an <E> element                   | //*[last()-1][name()='E'] | E:nth-last-child(2)
Parent & Child | 	Element <E1> with only <E2> children                          | //E1/[E2 and not( *[not(self::E2)])] |
Parent & Child | 	Parent of element <E>                                         | //E/.. |
Parent & Child | 	Descendant <E> of element with id I using specific path       | //*[@id='I']/ . . ./. . ./. . ./E | #I > . . . > . . . > . . . > E
Parent & Child | 	Descendant <E> of element with id I using unspecified path    | //*[@id='I']//E | #I E
Parent & Child | 	Element <E> with no children                                  | //E[count(*)=0] | E:empty
Parent & Child | 	Element <E> with an only child                                | //E[count(*)=1] |
Parent & Child | 	Element <E> that is an only child                             | //E[count(preceding-sibling::*)+count(following-sibling::*)=0] | E:only-child
Parent & Child | 	Element <E> with no <E> siblings                              | //E[count(../E) = 1] | E:only-of-type
Parent & Child | Every Nth element starting with the (M+1)th                    | //E[position() mod N = M + 1] | E:nth-child(Nn + M)
Sibling | Element <E1> following some sibling <E2>                       | //E2/following-sibling::E1 | E2 ~ E1
Sibling | 	Element <E1> immediately following sibling <E2>               | //E2/following-sibling::*[1][name()='E1'] | E2 + E1
Sibling | 	Element <E1> following sibling <E2> with one intermediary     | //E2/following-sibling::*[2][name()='E1'] | E2 + * + E1
Sibling | 	Sibling element immediately following <E>                     | //E/following-sibling::* | E + *
Sibling | 	Element <E1> preceding some sibling <E2>                      | //E2/preceding-sibling::E1 |
Sibling | 	Element <E1> immediately preceding sibling <E2>               | //E2/preceding-sibling::*[1][name()='E1'] |
Sibling | 	Element <E1> preceding sibling <E2> with one intermediary     | //E2/preceding-sibling::*[2][name()='E1'] |
Sibling | 	Sibling element immediately preceding <E>                     | //E/preceding-sibling::*[1] |
Table Cell | Cell by row and column (e.g. 3rd row, 2nd column)              | //*[@id='TestTable']//tr[3]//td[2]{Se: //*[@id='TestTable'].2.1 } | #TestTable tr:nth-child(3) td:nth-child(2){Se: #TestTable.2.1 }
Table Cell | 	Cell immediately following cell containing 't' exactly        | //td[preceding-sibling::td='t'] |
Table Cell | 	Cell immediately following cell containing 't'                | //td[preceding-sibling::td[contains(.,'t')]] | td:contains('t') ~ td
Dynamic | User interface element <E> that is disabled                    | //E[@disabled] | E:disabled
Dynamic | User interface element that is enabled                         | //*[not(@disabled)] | *:enabled
Dynamic | Checkbox (or radio button) that is checked                     | //*[@checked] | *:checked
Dynamic| replace                                                        |//*[not(contains(translate(@tag, "W1", "W2"), "W="))] |